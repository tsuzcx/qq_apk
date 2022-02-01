package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cdb
  extends erp
{
  public int IJG;
  public int YIc;
  public int YKo;
  public int YMX;
  public int aamE;
  public String aamF;
  public LinkedList<cda> aamG;
  public LinkedList<b> aamH;
  public String vYk;
  
  public cdb()
  {
    AppMethodBeat.i(152547);
    this.aamG = new LinkedList();
    this.aamH = new LinkedList();
    AppMethodBeat.o(152547);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152548);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YMX);
      paramVarArgs.bS(3, this.IJG);
      paramVarArgs.bS(4, this.YKo);
      paramVarArgs.bS(5, this.aamE);
      if (this.vYk != null) {
        paramVarArgs.g(6, this.vYk);
      }
      if (this.aamF != null) {
        paramVarArgs.g(7, this.aamF);
      }
      paramVarArgs.bS(8, this.YIc);
      paramVarArgs.e(9, 8, this.aamG);
      paramVarArgs.e(10, 6, this.aamH);
      AppMethodBeat.o(152548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label810;
      }
    }
    label810:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YMX) + i.a.a.b.b.a.cJ(3, this.IJG) + i.a.a.b.b.a.cJ(4, this.YKo) + i.a.a.b.b.a.cJ(5, this.aamE);
      paramInt = i;
      if (this.vYk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.vYk);
      }
      i = paramInt;
      if (this.aamF != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aamF);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.YIc);
      int j = i.a.a.a.c(9, 8, this.aamG);
      int k = i.a.a.a.c(10, 6, this.aamH);
      AppMethodBeat.o(152548);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aamG.clear();
        this.aamH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152548);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cdb localcdb = (cdb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152548);
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
            localcdb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        case 2: 
          localcdb.YMX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152548);
          return 0;
        case 3: 
          localcdb.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152548);
          return 0;
        case 4: 
          localcdb.YKo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152548);
          return 0;
        case 5: 
          localcdb.aamE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152548);
          return 0;
        case 6: 
          localcdb.vYk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 7: 
          localcdb.aamF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 8: 
          localcdb.YIc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152548);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cda();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cda)localObject2).parseFrom((byte[])localObject1);
            }
            localcdb.aamG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        }
        localcdb.aamH.add(((i.a.a.a.a)localObject1).ajGk.kFX());
        AppMethodBeat.o(152548);
        return 0;
      }
      AppMethodBeat.o(152548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdb
 * JD-Core Version:    0.7.0.1
 */