package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference
  extends Preference
{
  int JeO;
  String avatar;
  private String fPU;
  private String idS;
  private TextView jbe;
  Bitmap lAx;
  private TextView userTV;
  private String username;
  ImageView wRM;
  private View.OnClickListener xhO;
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jbe = null;
    this.userTV = null;
    this.wRM = null;
    this.lAx = null;
    this.JeO = -1;
    this.avatar = null;
  }
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73903);
    this.jbe = null;
    this.userTV = null;
    this.wRM = null;
    this.lAx = null;
    this.JeO = -1;
    this.avatar = null;
    setLayoutResource(b.g.mm_preference);
    auN(b.g.mm_preference_submenu);
    AppMethodBeat.o(73903);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73905);
    if (this.wRM == null) {
      this.wRM = ((ImageView)paramView.findViewById(b.f.image_iv));
    }
    if (this.lAx != null)
    {
      this.wRM.setImageBitmap(this.lAx);
      this.wRM.setOnClickListener(this.xhO);
      if ((this.jbe != null) && (this.fPU != null)) {
        this.jbe.setText(l.b(this.mContext, this.fPU, this.jbe.getTextSize()));
      }
      if (this.userTV != null) {
        if (!Util.isNullOrNil(this.idS)) {
          break label232;
        }
      }
    }
    label232:
    for (String str = this.username;; str = this.idS)
    {
      if ((Util.isNullOrNil(this.idS)) && (as.bvU(this.username))) {
        this.userTV.setVisibility(8);
      }
      this.userTV.setText(this.mContext.getString(b.i.app_field_username) + str);
      super.onBindView(paramView);
      AppMethodBeat.o(73905);
      return;
      if (this.JeO > 0)
      {
        this.wRM.setImageResource(this.JeO);
        break;
      }
      if (this.avatar == null) {
        break;
      }
      a.b.c(this.wRM, this.avatar);
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73904);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(b.f.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, b.g.mm_preference_content_personal, localViewGroup);
    AppMethodBeat.o(73904);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PersonalPreference
 * JD-Core Version:    0.7.0.1
 */