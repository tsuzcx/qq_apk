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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnsChatRoomMemberUI
  extends MMActivity
{
  private static int fzt = 5;
  private List<a> dom;
  private x ftP;
  private String fvZ;
  private String fxo;
  private int fxp;
  private String fxq;
  private boolean fxr;
  private com.tencent.mm.plugin.messenger.foundation.a.k fzB;
  private String mTitle;
  private GridView yIZ;
  private b yJa;
  
  public SnsChatRoomMemberUI()
  {
    AppMethodBeat.i(98527);
    this.yIZ = null;
    this.yJa = null;
    this.dom = new ArrayList();
    AppMethodBeat.o(98527);
  }
  
  private static int bV(Context paramContext)
  {
    AppMethodBeat.i(98528);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165500) * 2.0F + paramContext.getResources().getDimension(2131165508));
    i = (int)((i - paramContext.getResources().getDimension(2131165489) * 1.0F) / j);
    ac.i("MicroMsg.SnsChatRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    fzt = i;
    AppMethodBeat.o(98528);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495533;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98530);
    super.onConfigurationChanged(paramConfiguration);
    this.yIZ.setNumColumns(bV(this));
    AppMethodBeat.o(98530);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98529);
    super.onCreate(paramBundle);
    this.fzB = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class));
    this.fvZ = getIntent().getStringExtra("RoomInfo_Id");
    this.fxo = getIntent().getStringExtra("room_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.fxp = getIntent().getIntExtra("room_member_count", 0);
    this.ftP = ((c)g.ab(c.class)).awK().xN(this.fvZ);
    if (this.ftP != null)
    {
      this.fxq = this.ftP.field_roomowner;
      this.fxr = u.axw().equals(this.fxq);
    }
    this.yIZ = ((GridView)findViewById(2131304951));
    this.yIZ.setNumColumns(bV(this));
    this.yIZ.setColumnWidth(getResources().getDimensionPixelSize(2131165489));
    this.yIZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(98521);
        if (SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).Pu(paramAnonymousInt).type == 1)
        {
          ai localai = SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).Pu(paramAnonymousInt).contact;
          if (localai == null)
          {
            ac.e("MicroMsg.SnsChatRoomMemberUI", "cont is null");
            AppMethodBeat.o(98521);
            return;
          }
          String str1 = localai.field_username;
          String str2 = localai.field_nickname;
          paramAnonymousView = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.b(SnsChatRoomMemberUI.this), str1);
          paramAnonymousAdapterView = paramAnonymousView;
          if (bs.isNullOrNil(paramAnonymousView)) {
            paramAnonymousAdapterView = localai.aaS();
          }
          SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this, str1, paramAnonymousAdapterView, str2);
        }
        AppMethodBeat.o(98521);
      }
    });
    this.yJa = new b(this, this.ftP, this.fvZ, this.fxq);
    this.yIZ.setAdapter(this.yJa);
    paramBundle = q.vZ(this.fvZ);
    if (paramBundle != null)
    {
      this.dom.clear();
      int i = 0;
      if (i < paramBundle.size())
      {
        ai localai = this.fzB.awB().aNt((String)paramBundle.get(i));
        if ((localai != null) && (b.ln(localai.field_type)) && (!u.wh(localai.field_username)))
        {
          if (!this.ftP.xB(localai.field_username)) {
            break label353;
          }
          this.dom.add(new a(localai, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          label353:
          if (this.ftP.aMU(localai.field_username)) {
            this.dom.add(new a(localai, 2));
          } else {
            this.dom.add(new a(localai, 1));
          }
        }
      }
      Collections.sort(this.dom, new Comparator() {});
      this.yJa.notifyDataSetChanged();
    }
    setMMTitle(this.mTitle + "(" + this.dom.size() + ")");
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
    ai contact;
    int order = 0;
    int type = 1;
    
    public a(ai paramai, int paramInt)
    {
      this.contact = paramai;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private x ftP;
    private List<String> fzw;
    private boolean fzy = false;
    private String fzz = null;
    private Context mContext;
    private String roomId;
    
    public b(x paramx, String paramString, List<String> paramList)
    {
      this.ftP = paramString;
      this.roomId = paramList;
      this.fzw = null;
      Object localObject;
      this.fzz = localObject;
      this.mContext = paramx;
    }
    
    public final SnsChatRoomMemberUI.a Pu(int paramInt)
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
        localView = View.inflate(this.mContext, 2131495532, null);
        localc = new SnsChatRoomMemberUI.c((byte)0);
        localc.fuY = ((ImageView)localView.findViewById(2131304481));
        localc.fwp = ((TextView)localView.findViewById(2131304483));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.fwp.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.fzD = ((TextView)localView.findViewById(2131304484));
        localView.setTag(localc);
        if (localc.fzD != null) {
          localc.fzD.setVisibility(8);
        }
        paramView = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
        if ((paramView != null) && (paramView.type == 1))
        {
          ai localai = paramView.contact;
          a.b.c(localc.fuY, localai.field_username);
          str = SnsChatRoomMemberUI.c(this.ftP, localai.field_username);
          if (bs.isNullOrNil(localai.field_conRemark)) {
            break label376;
          }
          paramViewGroup = localai.field_conRemark;
          label214:
          paramView = paramViewGroup;
          if (bs.isNullOrNil(paramViewGroup)) {
            paramView = localai.aaR();
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
          localc.fwp.setVisibility(0);
          localc.fwp.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramViewGroup, localc.fwp.getTextSize()));
          if (localc.fzD != null)
          {
            paramView = a.H(localai);
            if (!TextUtils.isEmpty(paramView)) {
              break label382;
            }
            localc.fzD.setVisibility(8);
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
        label376:
        paramViewGroup = str;
        break label214;
        label382:
        localc.fzD.setVisibility(0);
        localc.fzD.setText(paramView);
      }
    }
  }
  
  static final class c
  {
    public ImageView fuY;
    public TextView fwp;
    public TextView fzD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */