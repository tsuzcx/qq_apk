package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvx
  extends erp
{
  public atz CJv;
  public aur ZDQ;
  public LinkedList<fhp> ZHE;
  public long aadJ;
  public dng aadK;
  public String finderUsername;
  
  public bvx()
  {
    AppMethodBeat.i(169053);
    this.ZHE = new LinkedList();
    AppMethodBeat.o(169053);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169054);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZHE);
      if (this.finderUsername != null) {
        paramVarArgs.g(3, this.finderUsername);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(4, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(5, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(7, this.aadJ);
      if (this.aadK != null)
      {
        paramVarArgs.qD(8, this.aadK.computeSize());
        this.aadK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label912;
      }
    }
    label912:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZHE);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.finderUsername);
      }
      i = paramInt;
      if (this.CJv != null) {
        i = paramInt + i.a.a.a.qC(4, this.CJv.computeSize());
      }
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZDQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.aadJ);
      paramInt = i;
      if (this.aadK != null) {
        paramInt = i + i.a.a.a.qC(8, this.aadK.computeSize());
      }
      AppMethodBeat.o(169054);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZHE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bvx localbvx = (bvx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(169054);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbvx.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhp)localObject2).parseFrom((byte[])localObject1);
            }
            localbvx.ZHE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 3: 
          localbvx.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169054);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbvx.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aur)localObject2).parseFrom((byte[])localObject1);
            }
            localbvx.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 7: 
          localbvx.aadJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169054);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dng();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dng)localObject2).parseFrom((byte[])localObject1);
          }
          localbvx.aadK = ((dng)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169054);
        return 0;
      }
      AppMethodBeat.o(169054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvx
 * JD-Core Version:    0.7.0.1
 */