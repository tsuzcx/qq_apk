package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dag
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public int VmF;
  public String Zje;
  public long Zqa;
  public String aaFK;
  public edd aaFL;
  public int aaFM;
  public int aaFN;
  public String aaFO;
  public String aatc;
  public int state;
  public int wso;
  public String wtN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72505);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aatc != null) {
        paramVarArgs.g(1, this.aatc);
      }
      if (this.Zje != null) {
        paramVarArgs.g(2, this.Zje);
      }
      paramVarArgs.bv(3, this.Zqa);
      paramVarArgs.bS(4, this.state);
      if (this.aaFK != null) {
        paramVarArgs.g(5, this.aaFK);
      }
      paramVarArgs.bS(6, this.VmF);
      if (this.aaFL != null)
      {
        paramVarArgs.qD(7, this.aaFL.computeSize());
        this.aaFL.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.HTK);
      paramVarArgs.bS(9, this.wso);
      paramVarArgs.bS(10, this.aaFM);
      paramVarArgs.bS(11, this.aaFN);
      if (this.aaFO != null) {
        paramVarArgs.g(12, this.aaFO);
      }
      if (this.wtN != null) {
        paramVarArgs.g(13, this.wtN);
      }
      AppMethodBeat.o(72505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aatc == null) {
        break label900;
      }
    }
    label900:
    for (paramInt = i.a.a.b.b.a.h(1, this.aatc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zje != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Zje);
      }
      i = i + i.a.a.b.b.a.q(3, this.Zqa) + i.a.a.b.b.a.cJ(4, this.state);
      paramInt = i;
      if (this.aaFK != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaFK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.VmF);
      paramInt = i;
      if (this.aaFL != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaFL.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.HTK) + i.a.a.b.b.a.cJ(9, this.wso) + i.a.a.b.b.a.cJ(10, this.aaFM) + i.a.a.b.b.a.cJ(11, this.aaFN);
      paramInt = i;
      if (this.aaFO != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaFO);
      }
      i = paramInt;
      if (this.wtN != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.wtN);
      }
      AppMethodBeat.o(72505);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dag localdag = (dag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72505);
          return -1;
        case 1: 
          localdag.aatc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 2: 
          localdag.Zje = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 3: 
          localdag.Zqa = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(72505);
          return 0;
        case 4: 
          localdag.state = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72505);
          return 0;
        case 5: 
          localdag.aaFK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 6: 
          localdag.VmF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72505);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            edd localedd = new edd();
            if ((localObject != null) && (localObject.length > 0)) {
              localedd.parseFrom((byte[])localObject);
            }
            localdag.aaFL = localedd;
            paramInt += 1;
          }
          AppMethodBeat.o(72505);
          return 0;
        case 8: 
          localdag.HTK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72505);
          return 0;
        case 9: 
          localdag.wso = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72505);
          return 0;
        case 10: 
          localdag.aaFM = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72505);
          return 0;
        case 11: 
          localdag.aaFN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72505);
          return 0;
        case 12: 
          localdag.aaFO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72505);
          return 0;
        }
        localdag.wtN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72505);
        return 0;
      }
      AppMethodBeat.o(72505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dag
 * JD-Core Version:    0.7.0.1
 */