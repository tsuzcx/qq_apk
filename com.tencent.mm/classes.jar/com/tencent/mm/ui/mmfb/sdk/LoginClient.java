package com.tencent.mm.ui.mmfb.sdk;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginClient
  implements Parcelable
{
  public static final Parcelable.Creator<LoginClient> CREATOR;
  Activity activity;
  LoginMethodHandler[] afzI;
  int afzJ;
  Request afzK;
  Map<String, String> afzL;
  Map<String, String> afzM;
  private int afzN;
  private int afzO;
  
  static
  {
    AppMethodBeat.i(250172);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(250172);
  }
  
  public LoginClient(Activity paramActivity)
  {
    this.afzJ = -1;
    this.afzN = 0;
    this.afzO = 0;
    this.activity = paramActivity;
  }
  
  public LoginClient(Parcel paramParcel)
  {
    AppMethodBeat.i(250169);
    this.afzJ = -1;
    this.afzN = 0;
    this.afzO = 0;
    Parcelable[] arrayOfParcelable = paramParcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
    this.afzI = new LoginMethodHandler[arrayOfParcelable.length];
    int i = 0;
    while (i < arrayOfParcelable.length)
    {
      this.afzI[i] = ((LoginMethodHandler)arrayOfParcelable[i]);
      this.afzI[i].a(this);
      i += 1;
    }
    this.afzJ = paramParcel.readInt();
    this.afzK = ((Request)paramParcel.readParcelable(Request.class.getClassLoader()));
    this.afzL = CustomTabLoginMethodHandler.v(paramParcel);
    this.afzM = CustomTabLoginMethodHandler.v(paramParcel);
    AppMethodBeat.o(250169);
  }
  
  static String jBS()
  {
    AppMethodBeat.i(250162);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("init", System.currentTimeMillis());
      label23:
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(250162);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label23;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(250181);
    paramParcel.writeParcelableArray(this.afzI, paramInt);
    paramParcel.writeInt(this.afzJ);
    paramParcel.writeParcelable(this.afzK, paramInt);
    LoginMethodHandler.a(paramParcel, this.afzL);
    LoginMethodHandler.a(paramParcel, this.afzM);
    AppMethodBeat.o(250181);
  }
  
  public static class Request
    implements Parcelable
  {
    public static final Parcelable.Creator<Request> CREATOR;
    Set<String> afyp;
    final String afyt;
    private final k afzP;
    private final d afzQ;
    boolean afzR;
    private String afzS;
    private String afzT;
    private String afzU;
    final String vcy;
    
    static
    {
      AppMethodBeat.i(250176);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(250176);
    }
    
    private Request(Parcel paramParcel)
    {
      AppMethodBeat.i(250168);
      this.afzR = false;
      Object localObject1 = paramParcel.readString();
      if (localObject1 != null)
      {
        localObject1 = k.valueOf((String)localObject1);
        this.afzP = ((k)localObject1);
        localObject1 = new ArrayList();
        paramParcel.readStringList((List)localObject1);
        this.afyp = new HashSet((Collection)localObject1);
        String str = paramParcel.readString();
        localObject1 = localObject2;
        if (str != null) {
          localObject1 = d.valueOf(str);
        }
        this.afzQ = ((d)localObject1);
        this.afyt = paramParcel.readString();
        this.vcy = paramParcel.readString();
        if (paramParcel.readByte() == 0) {
          break label151;
        }
      }
      label151:
      for (boolean bool = true;; bool = false)
      {
        this.afzR = bool;
        this.afzS = paramParcel.readString();
        this.afzT = paramParcel.readString();
        this.afzU = paramParcel.readString();
        AppMethodBeat.o(250168);
        return;
        localObject1 = null;
        break;
      }
    }
    
    public Request(k paramk, Set<String> paramSet, d paramd, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(250161);
      this.afzR = false;
      this.afzP = paramk;
      if (paramSet != null) {}
      for (;;)
      {
        this.afyp = paramSet;
        this.afzQ = paramd;
        this.afzT = paramString1;
        this.afyt = paramString2;
        this.vcy = paramString3;
        AppMethodBeat.o(250161);
        return;
        paramSet = new HashSet();
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(250184);
      Object localObject1;
      if (this.afzP != null)
      {
        localObject1 = this.afzP.name();
        paramParcel.writeString((String)localObject1);
        paramParcel.writeStringList(new ArrayList(this.afyp));
        localObject1 = localObject2;
        if (this.afzQ != null) {
          localObject1 = this.afzQ.name();
        }
        paramParcel.writeString((String)localObject1);
        paramParcel.writeString(this.afyt);
        paramParcel.writeString(this.vcy);
        if (!this.afzR) {
          break label132;
        }
      }
      label132:
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.afzS);
        paramParcel.writeString(this.afzT);
        paramParcel.writeString(this.afzU);
        AppMethodBeat.o(250184);
        return;
        localObject1 = null;
        break;
      }
    }
  }
  
  public static class Result
    implements Parcelable
  {
    public static final Parcelable.Creator<Result> CREATOR;
    public Map<String, String> afzL;
    public Map<String, String> afzM;
    final LoginClient.Result.a afzV;
    final AccessToken afzW;
    final LoginClient.Request afzX;
    final String cBF;
    final String cBH;
    
    static
    {
      AppMethodBeat.i(250211);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(250211);
    }
    
    private Result(Parcel paramParcel)
    {
      AppMethodBeat.i(250202);
      this.afzV = LoginClient.Result.a.valueOf(paramParcel.readString());
      this.afzW = ((AccessToken)paramParcel.readParcelable(AccessToken.class.getClassLoader()));
      this.cBF = paramParcel.readString();
      this.cBH = paramParcel.readString();
      this.afzX = ((LoginClient.Request)paramParcel.readParcelable(LoginClient.Request.class.getClassLoader()));
      this.afzL = CustomTabLoginMethodHandler.v(paramParcel);
      this.afzM = CustomTabLoginMethodHandler.v(paramParcel);
      AppMethodBeat.o(250202);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(250224);
      paramParcel.writeString(this.afzV.name());
      paramParcel.writeParcelable(this.afzW, paramInt);
      paramParcel.writeString(this.cBF);
      paramParcel.writeString(this.cBH);
      paramParcel.writeParcelable(this.afzX, paramInt);
      LoginMethodHandler.a(paramParcel, this.afzL);
      LoginMethodHandler.a(paramParcel, this.afzM);
      AppMethodBeat.o(250224);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.LoginClient
 * JD-Core Version:    0.7.0.1
 */