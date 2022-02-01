package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqo
  extends erp
{
  public String YRE;
  public LinkedList<String> Zvf;
  public eqi abuo;
  public erg abup;
  public int vhJ;
  
  public eqo()
  {
    AppMethodBeat.i(115964);
    this.Zvf = new LinkedList();
    AppMethodBeat.o(115964);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115965);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vhJ);
      if (this.abuo != null)
      {
        paramVarArgs.qD(3, this.abuo.computeSize());
        this.abuo.writeFields(paramVarArgs);
      }
      if (this.abup != null)
      {
        paramVarArgs.qD(4, this.abup.computeSize());
        this.abup.writeFields(paramVarArgs);
      }
      if (this.YRE != null) {
        paramVarArgs.g(5, this.YRE);
      }
      paramVarArgs.e(6, 1, this.Zvf);
      AppMethodBeat.o(115965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ);
      paramInt = i;
      if (this.abuo != null) {
        paramInt = i + i.a.a.a.qC(3, this.abuo.computeSize());
      }
      i = paramInt;
      if (this.abup != null) {
        i = paramInt + i.a.a.a.qC(4, this.abup.computeSize());
      }
      paramInt = i;
      if (this.YRE != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YRE);
      }
      i = i.a.a.a.c(6, 1, this.Zvf);
      AppMethodBeat.o(115965);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zvf.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(115965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eqo localeqo = (eqo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115965);
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
            localeqo.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 2: 
          localeqo.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115965);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqi)localObject2).parseFrom((byte[])localObject1);
            }
            localeqo.abuo = ((eqi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erg)localObject2).parseFrom((byte[])localObject1);
            }
            localeqo.abup = ((erg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 5: 
          localeqo.YRE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(115965);
          return 0;
        }
        localeqo.Zvf.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(115965);
        return 0;
      }
      AppMethodBeat.o(115965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqo
 * JD-Core Version:    0.7.0.1
 */