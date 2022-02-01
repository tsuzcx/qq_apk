package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class deg
  extends erp
{
  public int ZqK;
  public String aaJM;
  public int aaJN;
  public int aaJt;
  public int aaJu;
  public glg aaJv;
  public boolean aaJw;
  public String oOI;
  public String session_id;
  public b vgA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123618);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.vgA != null) {
        paramVarArgs.d(3, this.vgA);
      }
      if (this.aaJM != null) {
        paramVarArgs.g(4, this.aaJM);
      }
      paramVarArgs.bS(5, this.aaJt);
      paramVarArgs.bS(6, this.aaJu);
      if (this.aaJv != null)
      {
        paramVarArgs.qD(7, this.aaJv.computeSize());
        this.aaJv.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.ZqK);
      if (this.session_id != null) {
        paramVarArgs.g(9, this.session_id);
      }
      paramVarArgs.bS(10, this.aaJN);
      paramVarArgs.di(11, this.aaJw);
      AppMethodBeat.o(123618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label886;
      }
    }
    label886:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.vgA != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.vgA);
      }
      paramInt = i;
      if (this.aaJM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaJM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaJt) + i.a.a.b.b.a.cJ(6, this.aaJu);
      paramInt = i;
      if (this.aaJv != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaJv.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.ZqK);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.session_id);
      }
      i = i.a.a.b.b.a.cJ(10, this.aaJN);
      int j = i.a.a.b.b.a.ko(11);
      AppMethodBeat.o(123618);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        deg localdeg = (deg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123618);
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
            localdeg.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        case 2: 
          localdeg.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 3: 
          localdeg.vgA = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(123618);
          return 0;
        case 4: 
          localdeg.aaJM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 5: 
          localdeg.aaJt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123618);
          return 0;
        case 6: 
          localdeg.aaJu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123618);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new glg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((glg)localObject2).parseFrom((byte[])localObject1);
            }
            localdeg.aaJv = ((glg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        case 8: 
          localdeg.ZqK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123618);
          return 0;
        case 9: 
          localdeg.session_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 10: 
          localdeg.aaJN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123618);
          return 0;
        }
        localdeg.aaJw = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(123618);
        return 0;
      }
      AppMethodBeat.o(123618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deg
 * JD-Core Version:    0.7.0.1
 */