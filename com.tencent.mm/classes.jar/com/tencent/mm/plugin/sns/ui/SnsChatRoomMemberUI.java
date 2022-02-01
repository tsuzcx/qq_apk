package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnsChatRoomMemberUI
  extends MMActivity
{
  private static int jjW = 5;
  private GridView KOC;
  private b KOD;
  private List<a> fMr;
  private ah iXp;
  private String jaK;
  private String jhR;
  private int jhS;
  private String jhT;
  private boolean jhU;
  private n jkg;
  private String mTitle;
  
  public SnsChatRoomMemberUI()
  {
    AppMethodBeat.i(98527);
    this.KOC = null;
    this.KOD = null;
    this.fMr = new ArrayList();
    AppMethodBeat.o(98527);
  }
  
  private static int cm(Context paramContext)
  {
    AppMethodBeat.i(98528);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(i.d.MiddlePadding) * 2.0F + paramContext.getResources().getDimension(i.d.NormalAvatarSize));
    i = (int)((i - paramContext.getResources().getDimension(i.d.ListPadding) * 1.0F) / j);
    Log.i("MicroMsg.SnsChatRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    jjW = i;
    AppMethodBeat.o(98528);
    return i;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_chat_room_members_layout;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98530);
    super.onConfigurationChanged(paramConfiguration);
    this.KOC.setNumColumns(cm(this));
    AppMethodBeat.o(98530);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98529);
    super.onCreate(paramBundle);
    this.jkg = ((n)h.ae(n.class));
    this.jaK = getIntent().getStringExtra("RoomInfo_Id");
    this.jhR = getIntent().getStringExtra("room_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.jhS = getIntent().getIntExtra("room_member_count", 0);
    this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.jaK);
    if (this.iXp != null)
    {
      this.jhT = this.iXp.field_roomowner;
      this.jhU = z.bcZ().equals(this.jhT);
    }
    this.KOC = ((GridView)findViewById(i.f.sns_chatroom_member_gv));
    this.KOC.setNumColumns(cm(this));
    this.KOC.setColumnWidth(getResources().getDimensionPixelSize(i.d.ListPadding));
    this.KOC.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(98521);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).ahd(paramAnonymousInt).type == 1)
        {
          as localas = SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).ahd(paramAnonymousInt).contact;
          if (localas == null)
          {
            Log.e("MicroMsg.SnsChatRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(98521);
            return;
          }
          localObject = localas.field_username;
          String str = localas.field_nickname;
          paramAnonymousView = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.b(SnsChatRoomMemberUI.this), (String)localObject);
          paramAnonymousAdapterView = paramAnonymousView;
          if (Util.isNullOrNil(paramAnonymousView)) {
            paramAnonymousAdapterView = localas.ays();
          }
          SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this, (String)localObject, paramAnonymousAdapterView, str);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(98521);
      }
    });
    this.KOD = new b(this, this.iXp, this.jaK, this.jhT);
    this.KOC.setAdapter(this.KOD);
    paramBundle = v.Ps(this.jaK);
    if (paramBundle != null)
    {
      this.fMr.clear();
      int i = 0;
      if (i < paramBundle.size())
      {
        as localas = this.jkg.bbL().RG((String)paramBundle.get(i));
        if ((localas != null) && (d.rk(localas.field_type)) && (!z.PD(localas.field_username)))
        {
          if (!this.iXp.Rh(localas.field_username)) {
            break label353;
          }
          this.fMr.add(new a(localas, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          label353:
          if (this.iXp.bvA(localas.field_username)) {
            this.fMr.add(new a(localas, 2));
          } else {
            this.fMr.add(new a(localas, 1));
          }
        }
      }
      Collections.sort(this.fMr, new Comparator() {});
      this.KOD.notifyDataSetChanged();
    }
    setMMTitle(this.mTitle + "(" + this.fMr.size() + ")");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98522);
        SnsChatRoomMemberUI.this.setResult(0);
        SnsChatRoomMemberUI.this.finish();
        AppMethodBeat.o(98522);
        return true;
      }
    });
    AppMethodBeat.o(98529);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    as contact;
    int order = 0;
    int type = 1;
    
    public a(as paramas, int paramInt)
    {
      this.contact = paramas;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private ah iXp;
    private List<String> jkb;
    private boolean jkd = false;
    private String jke = null;
    private Context mContext;
    private String roomId;
    
    public b(ah paramah, String paramString1, String paramString2)
    {
      this.iXp = paramString1;
      this.roomId = paramString2;
      this.jkb = null;
      Object localObject;
      this.jke = localObject;
      this.mContext = paramah;
    }
    
    public final SnsChatRoomMemberUI.a ahd(int paramInt)
    {
      AppMethodBeat.i(98523);
      SnsChatRoomMemberUI.a locala = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
      AppMethodBeat.o(98523);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(98525);
      int i = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).size();
      AppMethodBeat.o(98525);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(98524);
      View localView;
      SnsChatRoomMemberUI.c localc;
      String str;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, i.g.sns_chat_room_members_item, null);
        localc = new SnsChatRoomMemberUI.c((byte)0);
        localc.iZG = ((ImageView)localView.findViewById(i.f.see_roommember_avatar));
        localc.jbe = ((TextView)localView.findViewById(i.f.see_roommember_name));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.jbe.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.jkj = ((TextView)localView.findViewById(i.f.see_roommember_name_sub_detail));
        localView.setTag(localc);
        if (localc.jkj != null) {
          localc.jkj.setVisibility(8);
        }
        paramView = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
        if ((paramView != null) && (paramView.type == 1))
        {
          as localas = paramView.contact;
          a.b.c(localc.iZG, localas.field_username);
          str = SnsChatRoomMemberUI.c(this.iXp, localas.field_username);
          if (Util.isNullOrNil(localas.field_conRemark)) {
            break label380;
          }
          paramViewGroup = localas.field_conRemark;
          label218:
          paramView = paramViewGroup;
          if (Util.isNullOrNil(paramViewGroup)) {
            paramView = localas.ayr();
          }
          paramViewGroup = paramView;
          if (str != null)
          {
            paramViewGroup = paramView;
            if (!str.equals(""))
            {
              paramViewGroup = paramView;
              if (!paramView.equals(str)) {
                paramViewGroup = str + "( " + paramView + " )";
              }
            }
          }
          localc.jbe.setVisibility(0);
          localc.jbe.setText(l.b(this.mContext, paramViewGroup, localc.jbe.getTextSize()));
          if (localc.jkj != null)
          {
            paramView = com.tencent.mm.openim.room.a.a.V(localas);
            if (!TextUtils.isEmpty(paramView)) {
              break label386;
            }
            localc.jkj.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(98524);
        return localView;
        localc = (SnsChatRoomMemberUI.c)paramView.getTag();
        localView = paramView;
        break;
        label380:
        paramViewGroup = str;
        break label218;
        label386:
        localc.jkj.setVisibility(0);
        localc.jkj.setText(paramView);
      }
    }
  }
  
  static final class c
  {
    public ImageView iZG;
    public TextView jbe;
    public TextView jkj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */