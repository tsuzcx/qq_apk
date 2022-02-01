package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

final class SDKOAuthUI$b
  extends BaseAdapter
{
  LinkedList<ddg> Qcs;
  private c.a Qct;
  private Context Qcu;
  private int Qcv;
  private LayoutInflater mInflater;
  
  public SDKOAuthUI$b(Context paramContext, LinkedList<ddg> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(79755);
    this.Qcu = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.Qcs = paramLinkedList;
    if (this.Qcs == null) {
      this.Qcs = new LinkedList();
    }
    Log.i("MicroMsg.SdkOAuthUI", "LoginAvatarListAdapter avatars size:%d", new Object[] { Integer.valueOf(this.Qcs.size()) });
    this.Qct = new c.a();
    this.Qct.lRP = c.h.native_oauth_default_head_img;
    paramContext = this.Qct;
    paramContext.kPz = true;
    paramContext.lRW = this.Qcu.getResources().getDimension(c.d.sdk_oauth_avatar_corners_size);
    this.Qcv = paramInt;
    AppMethodBeat.o(79755);
  }
  
  public final ddg aou(int paramInt)
  {
    AppMethodBeat.i(79757);
    if ((this.Qcs != null) && (paramInt >= 0) && (paramInt < this.Qcs.size()))
    {
      ddg localddg = (ddg)this.Qcs.get(paramInt);
      AppMethodBeat.o(79757);
      return localddg;
    }
    AppMethodBeat.o(79757);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(79756);
    if (this.Qcs == null)
    {
      AppMethodBeat.o(79756);
      return 0;
    }
    int i = this.Qcs.size();
    AppMethodBeat.o(79756);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(79758);
    ddg localddg = aou(paramInt);
    if (localddg == null)
    {
      AppMethodBeat.o(79758);
      return paramView;
    }
    View localView;
    if (paramView == null)
    {
      paramView = new a((byte)0);
      localView = this.mInflater.inflate(c.g.avatar_item, null, false);
      paramView.Qcw = ((ImageView)localView.findViewById(c.f.avatar_icon));
      paramView.Qcx = ((TextView)localView.findViewById(c.f.avatar_name));
      paramView.Qcy = ((TextView)localView.findViewById(c.f.avatar_comment));
      paramView.Qcz = ((ImageView)localView.findViewById(c.f.avatar_state));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.Qcx.setText(l.b(this.Qcu, localddg.nickname, paramViewGroup.Qcx.getTextSize()));
      q.bml().a(localddg.oDV, paramViewGroup.Qcw, this.Qct.bmL());
      if (localddg.desc == null) {
        break label237;
      }
      paramViewGroup.Qcy.setText(localddg.desc);
      paramViewGroup.Qcy.setVisibility(0);
      label195:
      if (localddg.id != this.Qcv) {
        break label249;
      }
      paramViewGroup.Qcz.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(79758);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label237:
      paramViewGroup.Qcy.setVisibility(8);
      break label195;
      label249:
      paramViewGroup.Qcz.setVisibility(4);
    }
  }
  
  static final class a
  {
    ImageView Qcw;
    TextView Qcx;
    TextView Qcy;
    ImageView Qcz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.b
 * JD-Core Version:    0.7.0.1
 */