package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dec
  extends erp
{
  public int aaJG;
  public String aaJH;
  public LinkedList<String> aaJs;
  public int aaJt;
  public int aaJu;
  public glg aaJv;
  public String oOI;
  
  public dec()
  {
    AppMethodBeat.i(123611);
    this.aaJs = new LinkedList();
    AppMethodBeat.o(123611);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123612);
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
      paramVarArgs.e(3, 1, this.aaJs);
      paramVarArgs.bS(4, this.aaJG);
      if (this.aaJH != null) {
        paramVarArgs.g(6, this.aaJH);
      }
      paramVarArgs.bS(7, this.aaJt);
      paramVarArgs.bS(8, this.aaJu);
      if (this.aaJv != null)
      {
        paramVarArgs.qD(9, this.aaJv.computeSize());
        this.aaJv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = i + i.a.a.a.c(3, 1, this.aaJs) + i.a.a.b.b.a.cJ(4, this.aaJG);
      paramInt = i;
      if (this.aaJH != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaJH);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.aaJt) + i.a.a.b.b.a.cJ(8, this.aaJu);
      paramInt = i;
      if (this.aaJv != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaJv.computeSize());
      }
      AppMethodBeat.o(123612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaJs.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dec localdec = (dec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(123612);
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
            localdec.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123612);
          return 0;
        case 2: 
          localdec.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123612);
          return 0;
        case 3: 
          localdec.aaJs.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(123612);
          return 0;
        case 4: 
          localdec.aaJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123612);
          return 0;
        case 6: 
          localdec.aaJH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123612);
          return 0;
        case 7: 
          localdec.aaJt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123612);
          return 0;
        case 8: 
          localdec.aaJu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123612);
          return 0;
        }
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
          localdec.aaJv = ((glg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123612);
        return 0;
      }
      AppMethodBeat.o(123612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dec
 * JD-Core Version:    0.7.0.1
 */