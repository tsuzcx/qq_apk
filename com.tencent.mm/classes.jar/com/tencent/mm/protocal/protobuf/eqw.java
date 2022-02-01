package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqw
  extends erp
{
  public long aaxM;
  public acz aaxN;
  public LinkedList<aot> abuu;
  public int abuv;
  public int abuw;
  public LinkedList<acu> abux;
  public int start_time;
  
  public eqw()
  {
    AppMethodBeat.i(50105);
    this.abuu = new LinkedList();
    this.abux = new LinkedList();
    AppMethodBeat.o(50105);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50106);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aaxM);
      paramVarArgs.e(3, 8, this.abuu);
      paramVarArgs.bS(5, this.abuv);
      paramVarArgs.bS(6, this.abuw);
      if (this.aaxN != null)
      {
        paramVarArgs.qD(7, this.aaxN.computeSize());
        this.aaxN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.abux);
      paramVarArgs.bS(9, this.start_time);
      AppMethodBeat.o(50106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aaxM) + i.a.a.a.c(3, 8, this.abuu) + i.a.a.b.b.a.cJ(5, this.abuv) + i.a.a.b.b.a.cJ(6, this.abuw);
      paramInt = i;
      if (this.aaxN != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaxN.computeSize());
      }
      i = i.a.a.a.c(8, 8, this.abux);
      int j = i.a.a.b.b.a.cJ(9, this.start_time);
      AppMethodBeat.o(50106);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abuu.clear();
        this.abux.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eqw localeqw = (eqw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        default: 
          AppMethodBeat.o(50106);
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
            localeqw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 2: 
          localeqw.aaxM = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(50106);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aot();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aot)localObject2).parseFrom((byte[])localObject1);
            }
            localeqw.abuu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 5: 
          localeqw.abuv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(50106);
          return 0;
        case 6: 
          localeqw.abuw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(50106);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acz)localObject2).parseFrom((byte[])localObject1);
            }
            localeqw.aaxN = ((acz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acu)localObject2).parseFrom((byte[])localObject1);
            }
            localeqw.abux.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        }
        localeqw.start_time = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(50106);
        return 0;
      }
      AppMethodBeat.o(50106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqw
 * JD-Core Version:    0.7.0.1
 */