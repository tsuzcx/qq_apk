package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class MallFunction
  implements Parcelable
{
  public static final Parcelable.Creator<MallFunction> CREATOR;
  public String Dbn;
  public ArrayList<String> Dbo;
  public MallNews Dbp;
  public String Dbq;
  public int Dbr;
  public String dKm;
  public String dNL;
  public String jDb;
  public int type;
  public String usV;
  public String vEl;
  public String vEm;
  
  static
  {
    AppMethodBeat.i(70538);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70538);
  }
  
  public MallFunction()
  {
    this.Dbr = 0;
  }
  
  public MallFunction(Parcel paramParcel)
  {
    AppMethodBeat.i(70536);
    this.Dbr = 0;
    this.jDb = paramParcel.readString();
    this.dKm = paramParcel.readString();
    this.Dbn = paramParcel.readString();
    this.vEl = paramParcel.readString();
    this.vEm = paramParcel.readString();
    this.dNL = paramParcel.readString();
    this.usV = paramParcel.readString();
    this.Dbo = new ArrayList();
    paramParcel.readStringList(this.Dbo);
    this.Dbp = ((MallNews)paramParcel.readParcelable(MallNews.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.Dbq = paramParcel.readString();
    this.Dbr = paramParcel.readInt();
    AppMethodBeat.o(70536);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70537);
    paramParcel.writeString(this.jDb);
    paramParcel.writeString(this.dKm);
    paramParcel.writeString(this.Dbn);
    paramParcel.writeString(this.vEl);
    paramParcel.writeString(this.vEm);
    paramParcel.writeString(this.dNL);
    paramParcel.writeString(this.usV);
    paramParcel.writeStringList(this.Dbo);
    paramParcel.writeParcelable(this.Dbp, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.Dbq);
    paramParcel.writeInt(this.Dbr);
    AppMethodBeat.o(70537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.MallFunction
 * JD-Core Version:    0.7.0.1
 */