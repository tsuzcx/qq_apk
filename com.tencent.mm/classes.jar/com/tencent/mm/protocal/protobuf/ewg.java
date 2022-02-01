package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ewg
  extends esc
{
  public String IGI;
  public int IHl;
  public String UserName;
  public int aaJu;
  public String abyI;
  public String abyJ;
  public String abyK;
  public int crz;
  public String vhX;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259854);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "JumpType", Integer.valueOf(this.IHl), false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappUrl", this.abyI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "VersionType", Integer.valueOf(this.aaJu), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Appid", this.abyJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NickName", this.vhX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "JumpUrl", this.IGI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WebviewJson", this.abyK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Version", Integer.valueOf(this.crz), false);
      label132:
      AppMethodBeat.o(259854);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label132;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259857);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IHl);
      if (this.UserName != null) {
        paramVarArgs.g(3, this.UserName);
      }
      if (this.abyI != null) {
        paramVarArgs.g(4, this.abyI);
      }
      paramVarArgs.bS(5, this.aaJu);
      if (this.abyJ != null) {
        paramVarArgs.g(6, this.abyJ);
      }
      if (this.vhX != null) {
        paramVarArgs.g(7, this.vhX);
      }
      if (this.IGI != null) {
        paramVarArgs.g(8, this.IGI);
      }
      if (this.abyK != null) {
        paramVarArgs.g(9, this.abyK);
      }
      paramVarArgs.bS(10, this.crz);
      AppMethodBeat.o(259857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label788;
      }
    }
    label788:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IHl);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.UserName);
      }
      i = paramInt;
      if (this.abyI != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abyI);
      }
      i += i.a.a.b.b.a.cJ(5, this.aaJu);
      paramInt = i;
      if (this.abyJ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abyJ);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.vhX);
      }
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.IGI);
      }
      i = paramInt;
      if (this.abyK != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abyK);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.crz);
      AppMethodBeat.o(259857);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ewg localewg = (ewg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259857);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localewg.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259857);
          return 0;
        case 2: 
          localewg.IHl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259857);
          return 0;
        case 3: 
          localewg.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259857);
          return 0;
        case 4: 
          localewg.abyI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259857);
          return 0;
        case 5: 
          localewg.aaJu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259857);
          return 0;
        case 6: 
          localewg.abyJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259857);
          return 0;
        case 7: 
          localewg.vhX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259857);
          return 0;
        case 8: 
          localewg.IGI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259857);
          return 0;
        case 9: 
          localewg.abyK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259857);
          return 0;
        }
        localewg.crz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259857);
        return 0;
      }
      AppMethodBeat.o(259857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewg
 * JD-Core Version:    0.7.0.1
 */