package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h.c;

final class FriendPreference$1$1
  implements h.c
{
  FriendPreference$1$1(FriendPreference.1 param1, String[] paramArrayOfString) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while ((this.mXZ.mXX == null) || (this.mXZ.mXX.length() == 0));
              paramInt = this.mXZ.mXX.lastIndexOf(' ') + 1;
            } while (paramInt <= 0);
            FriendPreference.a(this.mXZ.mXY, this.mXZ.mXX.substring(paramInt));
            return;
          } while ((this.mXZ.mXX == null) || (this.mXZ.mXX.length() == 0));
          paramInt = this.mXZ.mXX.lastIndexOf(' ');
          localObject = this.mXZ.mXX.substring(0, paramInt);
        } while ((localObject == null) || (((String)localObject).length() == 0));
        s.b(FriendPreference.c(this.mXZ.mXY), ((String)localObject).trim());
        return;
      } while ((this.mWJ == null) || (this.mWJ.length <= 2) || (FriendPreference.a(this.mXZ.mXY) == null) || (FriendPreference.c(this.mXZ.mXY) == null));
      if ((FriendPreference.a(this.mXZ.mXY) != null) && (!bk.bl(FriendPreference.a(this.mXZ.mXY).ebN)))
      {
        FriendPreference.a(this.mXZ.mXY, FriendPreference.c(this.mXZ.mXY).field_username, FriendPreference.a(this.mXZ.mXY).ebN);
        return;
      }
      break;
    }
    Object localObject = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromScene", 2);
    ((Intent)localObject).putExtra("reportArgs", localBundle);
    com.tencent.mm.plugin.profile.a.eUR.k((Intent)localObject, FriendPreference.b(this.mXZ.mXY));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference.1.1
 * JD-Core Version:    0.7.0.1
 */