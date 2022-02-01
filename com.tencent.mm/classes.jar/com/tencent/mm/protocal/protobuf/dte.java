package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class dte
  extends com.tencent.mm.bx.a
{
  public String ZWS;
  public String aaYE;
  public String aaYF;
  public String aaYG;
  public String aaYH;
  public String aaYI;
  public String aaYJ;
  public String appId;
  public String musicId;
  public int musicType;
  public String name;
  public dtj oPb;
  public String rDl;
  public String rDm;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259431);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "musicShareObject", this.oPb, false);
      com.tencent.mm.bk.a.a(localJSONObject, "musicType", Integer.valueOf(this.musicType), false);
      com.tencent.mm.bk.a.a(localJSONObject, "albumUrl", this.ZWS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "name", this.name, false);
      com.tencent.mm.bk.a.a(localJSONObject, "singer", this.rDl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "webUrl", this.rDm, false);
      com.tencent.mm.bk.a.a(localJSONObject, "wapLinUrl", this.aaYE, false);
      com.tencent.mm.bk.a.a(localJSONObject, "wifiUrl", this.aaYF, false);
      com.tencent.mm.bk.a.a(localJSONObject, "musicId", this.musicId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "songPath", this.aaYG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "albumPath", this.aaYH, false);
      com.tencent.mm.bk.a.a(localJSONObject, "songAlbum", this.aaYI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "appId", this.appId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "songHAlbumUrl", this.aaYJ, false);
      label170:
      AppMethodBeat.o(259431);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label170;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259435);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oPb != null)
      {
        paramVarArgs.qD(1, this.oPb.computeSize());
        this.oPb.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.musicType);
      if (this.ZWS != null) {
        paramVarArgs.g(3, this.ZWS);
      }
      if (this.name != null) {
        paramVarArgs.g(4, this.name);
      }
      if (this.rDl != null) {
        paramVarArgs.g(5, this.rDl);
      }
      if (this.rDm != null) {
        paramVarArgs.g(6, this.rDm);
      }
      if (this.aaYE != null) {
        paramVarArgs.g(7, this.aaYE);
      }
      if (this.aaYF != null) {
        paramVarArgs.g(8, this.aaYF);
      }
      if (this.musicId != null) {
        paramVarArgs.g(9, this.musicId);
      }
      if (this.aaYG != null) {
        paramVarArgs.g(10, this.aaYG);
      }
      if (this.aaYH != null) {
        paramVarArgs.g(11, this.aaYH);
      }
      if (this.aaYI != null) {
        paramVarArgs.g(12, this.aaYI);
      }
      if (this.appId != null) {
        paramVarArgs.g(13, this.appId);
      }
      if (this.aaYJ != null) {
        paramVarArgs.g(14, this.aaYJ);
      }
      AppMethodBeat.o(259435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oPb == null) {
        break label1068;
      }
    }
    label1068:
    for (paramInt = i.a.a.a.qC(1, this.oPb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.musicType);
      paramInt = i;
      if (this.ZWS != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZWS);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.name);
      }
      paramInt = i;
      if (this.rDl != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.rDl);
      }
      i = paramInt;
      if (this.rDm != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.rDm);
      }
      paramInt = i;
      if (this.aaYE != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaYE);
      }
      i = paramInt;
      if (this.aaYF != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaYF);
      }
      paramInt = i;
      if (this.musicId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.musicId);
      }
      i = paramInt;
      if (this.aaYG != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aaYG);
      }
      paramInt = i;
      if (this.aaYH != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aaYH);
      }
      i = paramInt;
      if (this.aaYI != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aaYI);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.appId);
      }
      i = paramInt;
      if (this.aaYJ != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.aaYJ);
      }
      AppMethodBeat.o(259435);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dte localdte = (dte)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259435);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dtj localdtj = new dtj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdtj.parseFrom((byte[])localObject);
            }
            localdte.oPb = localdtj;
            paramInt += 1;
          }
          AppMethodBeat.o(259435);
          return 0;
        case 2: 
          localdte.musicType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259435);
          return 0;
        case 3: 
          localdte.ZWS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 4: 
          localdte.name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 5: 
          localdte.rDl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 6: 
          localdte.rDm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 7: 
          localdte.aaYE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 8: 
          localdte.aaYF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 9: 
          localdte.musicId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 10: 
          localdte.aaYG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 11: 
          localdte.aaYH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 12: 
          localdte.aaYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        case 13: 
          localdte.appId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259435);
          return 0;
        }
        localdte.aaYJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259435);
        return 0;
      }
      AppMethodBeat.o(259435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dte
 * JD-Core Version:    0.7.0.1
 */