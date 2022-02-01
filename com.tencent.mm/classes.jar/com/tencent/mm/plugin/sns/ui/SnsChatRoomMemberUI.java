package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnsChatRoomMemberUI
  extends MMActivity
{
  private static int lMA = 5;
  private GridView Rop;
  private b Roq;
  private List<a> hSb;
  private String lKh;
  private int lKi;
  private String lKj;
  private boolean lKk;
  private n lMK;
  private String lyn;
  private aj lzy;
  private String mTitle;
  
  public SnsChatRoomMemberUI()
  {
    AppMethodBeat.i(98527);
    this.Rop = null;
    this.Roq = null;
    this.hSb = new ArrayList();
    AppMethodBeat.o(98527);
  }
  
  private static int da(Context paramContext)
  {
    AppMethodBeat.i(98528);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(b.d.MiddlePadding) * 2.0F + paramContext.getResources().getDimension(b.d.NormalAvatarSize));
    i = (int)((i - paramContext.getResources().getDimension(b.d.ListPadding) * 1.0F) / j);
    Log.i("MicroMsg.SnsChatRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    lMA = i;
    AppMethodBeat.o(98528);
    return i;
  }
  
  public int getLayoutId()
  {
    return b.g.sns_chat_room_members_layout;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98530);
    super.onConfigurationChanged(paramConfiguration);
    this.Rop.setNumColumns(da(this));
    AppMethodBeat.o(98530);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98529);
    super.onCreate(paramBundle);
    this.lMK = ((n)h.ax(n.class));
    this.lyn = getIntent().getStringExtra("RoomInfo_Id");
    this.lKh = getIntent().getStringExtra("room_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.lKi = getIntent().getIntExtra("room_member_count", 0);
    this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.lyn);
    if (this.lzy != null)
    {
      this.lKj = this.lzy.field_roomowner;
      this.lKk = z.bAM().equals(this.lKj);
    }
    this.Rop = ((GridView)findViewById(b.f.sns_chatroom_member_gv));
    this.Rop.setNumColumns(da(this));
    this.Rop.setColumnWidth(getResources().getDimensionPixelSize(b.d.ListPadding));
    this.Rop.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(98521);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).alX(paramAnonymousInt).type == 1)
        {
          au localau = SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).alX(paramAnonymousInt).contact;
          if (localau == null)
          {
            Log.e("MicroMsg.SnsChatRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(98521);
            return;
          }
          localObject = localau.field_username;
          String str = localau.field_nickname;
          paramAnonymousView = SnsChatRoomMemberUI.e(SnsChatRoomMemberUI.b(SnsChatRoomMemberUI.this), (String)localObject);
          paramAnonymousAdapterView = paramAnonymousView;
          if (Util.isNullOrNil(paramAnonymousView)) {
            paramAnonymousAdapterView = localau.aSV();
          }
          SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this, (String)localObject, paramAnonymousAdapterView, str);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(98521);
      }
    });
    this.Roq = new b(this, this.lzy, this.lyn, this.lKj);
    this.Rop.setAdapter(this.Roq);
    paramBundle = v.Il(this.lyn);
    if (paramBundle != null)
    {
      this.hSb.clear();
      int i = 0;
      if (i < paramBundle.size())
      {
        au localau = this.lMK.bzA().JE((String)paramBundle.get(i));
        if ((localau != null) && (d.rs(localau.field_type)) && (!z.Iy(localau.field_username)))
        {
          if (!this.lzy.Jf(localau.field_username)) {
            break label353;
          }
          this.hSb.add(new a(localau, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          label353:
          if (this.lzy.bvK(localau.field_username)) {
            this.hSb.add(new a(localau, 2));
          } else {
            this.hSb.add(new a(localau, 1));
          }
        }
      }
      Collections.sort(this.hSb, new Comparator() {});
      this.Roq.notifyDataSetChanged();
    }
    setMMTitle(this.mTitle + "(" + this.hSb.size() + ")");
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
    au contact;
    int order = 0;
    int type = 1;
    
    public a(au paramau, int paramInt)
    {
      this.contact = paramau;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<String> lMF;
    private boolean lMH = false;
    private String lMI = null;
    private aj lzy;
    private Context mContext;
    private String roomId;
    
    public b(aj paramaj, String paramString1, String paramString2)
    {
      this.lzy = paramString1;
      this.roomId = paramString2;
      this.lMF = null;
      Object localObject;
      this.lMI = localObject;
      this.mContext = paramaj;
    }
    
    public final SnsChatRoomMemberUI.a alX(int paramInt)
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
        localView = View.inflate(this.mContext, b.g.sns_chat_room_members_item, null);
        localc = new SnsChatRoomMemberUI.c((byte)0);
        localc.lBC = ((ImageView)localView.findViewById(b.f.see_roommember_avatar));
        localc.lDe = ((TextView)localView.findViewById(b.f.see_roommember_name));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.lDe.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.lMN = ((TextView)localView.findViewById(b.f.see_roommember_name_sub_detail));
        localView.setTag(localc);
        if (localc.lMN != null) {
          localc.lMN.setVisibility(8);
        }
        paramView = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
        if ((paramView != null) && (paramView.type == 1))
        {
          au localau = paramView.contact;
          a.b.g(localc.lBC, localau.field_username);
          str = SnsChatRoomMemberUI.e(this.lzy, localau.field_username);
          if (Util.isNullOrNil(localau.field_conRemark)) {
            break label380;
          }
          paramViewGroup = localau.field_conRemark;
          label218:
          paramView = paramViewGroup;
          if (Util.isNullOrNil(paramViewGroup)) {
            paramView = localau.aSU();
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
          localc.lDe.setVisibility(0);
          localc.lDe.setText(p.b(this.mContext, paramViewGroup, localc.lDe.getTextSize()));
          if (localc.lMN != null)
          {
            paramView = com.tencent.mm.openim.room.a.a.X(localau);
            if (!TextUtils.isEmpty(paramView)) {
              break label386;
            }
            localc.lMN.setVisibility(8);
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
        localc.lMN.setVisibility(0);
        localc.lMN.setText(paramView);
      }
    }
  }
  
  static final class c
  {
    public ImageView lBC;
    public TextView lDe;
    public TextView lMN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */