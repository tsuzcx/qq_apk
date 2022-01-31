package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.xweb.k;

final class a$8
  implements View.OnClickListener
{
  a$8(a parama, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    paramView = k.cSk();
    boolean bool;
    Button localButton;
    if (!k.cSk().xgT)
    {
      bool = true;
      paramView.os(bool);
      localButton = this.xlj;
      if (!k.cSk().xgT) {
        break label48;
      }
    }
    label48:
    for (paramView = "使用正式版config";; paramView = "使用测试config")
    {
      localButton.setText(paramView);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.8
 * JD-Core Version:    0.7.0.1
 */