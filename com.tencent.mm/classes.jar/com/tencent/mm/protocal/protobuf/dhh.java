package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhh
  extends erp
{
  public int YIq;
  public float ZaG;
  public float ZaH;
  public int Zyl;
  public String Zym;
  public String Zyn;
  public int Zyo;
  public int aaMD;
  public int aaME;
  public String oPp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89929);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      paramVarArgs.l(3, this.ZaG);
      paramVarArgs.l(4, this.ZaH);
      paramVarArgs.bS(5, this.Zyl);
      if (this.Zym != null) {
        paramVarArgs.g(6, this.Zym);
      }
      if (this.Zyn != null) {
        paramVarArgs.g(7, this.Zyn);
      }
      paramVarArgs.bS(8, this.Zyo);
      if (this.oPp != null) {
        paramVarArgs.g(9, this.oPp);
      }
      paramVarArgs.bS(10, this.aaMD);
      paramVarArgs.bS(11, this.aaME);
      AppMethodBeat.o(89929);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq) + (i.a.a.b.b.a.ko(3) + 4) + (i.a.a.b.b.a.ko(4) + 4) + i.a.a.b.b.a.cJ(5, this.Zyl);
      paramInt = i;
      if (this.Zym != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zym);
      }
      i = paramInt;
      if (this.Zyn != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Zyn);
      }
      i += i.a.a.b.b.a.cJ(8, this.Zyo);
      paramInt = i;
      if (this.oPp != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.oPp);
      }
      i = i.a.a.b.b.a.cJ(10, this.aaMD);
      int j = i.a.a.b.b.a.cJ(11, this.aaME);
      AppMethodBeat.o(89929);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(89929);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dhh localdhh = (dhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89929);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localdhh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(89929);
          return 0;
        case 2: 
          localdhh.YIq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(89929);
          return 0;
        case 3: 
          localdhh.ZaG = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(89929);
          return 0;
        case 4: 
          localdhh.ZaH = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(89929);
          return 0;
        case 5: 
          localdhh.Zyl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(89929);
          return 0;
        case 6: 
          localdhh.Zym = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 7: 
          localdhh.Zyn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 8: 
          localdhh.Zyo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(89929);
          return 0;
        case 9: 
          localdhh.oPp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 10: 
          localdhh.aaMD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(89929);
          return 0;
        }
        localdhh.aaME = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(89929);
        return 0;
      }
      AppMethodBeat.o(89929);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhh
 * JD-Core Version:    0.7.0.1
 */