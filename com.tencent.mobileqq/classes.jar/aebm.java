import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import java.util.List;

public class aebm
  extends BaseAdapter
{
  private aebm(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.a.jdField_a_of_type_JavaUtilList.size()) {
      return Math.min(i, this.a.jdField_a_of_type_Int);
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      return (aebl)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str;
    FaceDrawable localFaceDrawable;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130969120, paramViewGroup, false);
      paramViewGroup = new aebo(this.a, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365240));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365243));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131365241));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365242);
      paramView.setTag(paramViewGroup);
      WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.a.app.a(107);
      aebl localaebl = (aebl)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = localaebl.jdField_a_of_type_JavaLangString;
      if ((!((FriendsManager)this.a.app.getManager(50)).b(((aebl)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
        break label314;
      }
      localFaceDrawable = FaceDrawable.a(this.a.app, 1, str);
      label201:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      localWerewolvesHandler.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
      if (!localaebl.jdField_a_of_type_Boolean) {
        break label335;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label239:
      if ((!this.a.jdField_a_of_type_Boolean) || (localaebl.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label346;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new aebn(this, paramInt, localWerewolvesHandler));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = 1;
      return paramView;
      paramViewGroup = (aebo)paramView.getTag();
      break;
      label314:
      localFaceDrawable = FaceDrawable.b(this.a.app, 200, str, 3);
      break label201;
      label335:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
      break label239;
      label346:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aebm
 * JD-Core Version:    0.7.0.1
 */