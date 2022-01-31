import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.EmotcationConstants;

public class acnk
  extends EmoticonLinearLayout.EmoticonAdapter
{
  private int e;
  private int f;
  
  public acnk(EmoticonPanelViewBinder paramEmoticonPanelViewBinder, int paramInt)
  {
    this.e = ((int)(paramEmoticonPanelViewBinder.a.getResources().getDisplayMetrics().density * 30.0F));
    this.f = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131361968);
    localImageView.setVisibility(0);
    localImageView.setTag(Boolean.valueOf(false));
    EmoticonInfo localEmoticonInfo = a(paramInt);
    paramRelativeLayout.setTag(localEmoticonInfo);
    if ((localEmoticonInfo != null) && ((localEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)))
    {
      paramViewGroup = (SystemAndEmojiEmoticonInfo)localEmoticonInfo;
      paramInt = paramViewGroup.b;
      if (paramViewGroup.a != 1) {
        break label256;
      }
      if ((paramInt >= 0) && (paramInt < EmotcationConstants.a.length))
      {
        String str = EmotcationConstants.a[paramInt];
        paramViewGroup = str;
        if (str != null)
        {
          paramViewGroup = str;
          if (str.startsWith("/"))
          {
            paramViewGroup = str;
            if (str.length() > 1) {
              paramViewGroup = str.substring(1);
            }
          }
        }
        if (paramViewGroup != null) {
          paramRelativeLayout.setContentDescription(paramViewGroup);
        }
      }
    }
    label255:
    do
    {
      break label255;
      paramViewGroup = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      float f1 = this.a.a.getResources().getDisplayMetrics().density;
      if (localEmoticonInfo == null) {
        break;
      }
      if ((localEmoticonInfo.c == 1) || (localEmoticonInfo.c == 2) || (localEmoticonInfo.c == 7))
      {
        paramViewGroup.width = this.e;
        paramViewGroup.height = this.e;
      }
      if (localEmoticonInfo.c != -1)
      {
        paramRelativeLayout = localEmoticonInfo.a(this.a.a, f1);
        if (paramRelativeLayout != null) {
          localImageView.setImageDrawable(paramRelativeLayout);
        }
        for (;;)
        {
          localImageView.setBackgroundDrawable(null);
          return;
          if (paramViewGroup.a != 2) {
            break;
          }
          paramRelativeLayout.setContentDescription(EmotcationConstants.a(paramInt));
          break;
          localImageView.setVisibility(4);
        }
      }
    } while (!"delete".equals(localEmoticonInfo.a));
    label256:
    localImageView.setImageResource(2130838733);
    paramRelativeLayout.setContentDescription("删除");
    return;
    localImageView.setImageDrawable(null);
    localImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acnk
 * JD-Core Version:    0.7.0.1
 */