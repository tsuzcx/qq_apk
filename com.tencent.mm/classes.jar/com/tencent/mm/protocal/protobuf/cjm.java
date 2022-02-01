package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cjm
  extends erp
{
  public int IJG;
  public int aasa;
  public akf aasb;
  public LinkedList<aov> aasc;
  public int aasd;
  public String aase;
  
  public cjm()
  {
    AppMethodBeat.i(258470);
    this.aasc = new LinkedList();
    AppMethodBeat.o(258470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258474);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aasb == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(258474);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aasa);
      paramVarArgs.bS(3, this.IJG);
      if (this.aasb != null)
      {
        paramVarArgs.qD(4, this.aasb.computeSize());
        this.aasb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.aasc);
      paramVarArgs.bS(6, this.aasd);
      if (this.aase != null) {
        paramVarArgs.g(7, this.aase);
      }
      AppMethodBeat.o(258474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label776;
      }
    }
    label776:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aasa) + i.a.a.b.b.a.cJ(3, this.IJG);
      paramInt = i;
      if (this.aasb != null) {
        paramInt = i + i.a.a.a.qC(4, this.aasb.computeSize());
      }
      i = paramInt + i.a.a.a.c(5, 8, this.aasc) + i.a.a.b.b.a.cJ(6, this.aasd);
      paramInt = i;
      if (this.aase != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aase);
      }
      AppMethodBeat.o(258474);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aasc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aasb == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(258474);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cjm localcjm = (cjm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258474);
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
            localcjm.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258474);
          return 0;
        case 2: 
          localcjm.aasa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258474);
          return 0;
        case 3: 
          localcjm.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258474);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akf)localObject2).parseFrom((byte[])localObject1);
            }
            localcjm.aasb = ((akf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258474);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aov();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aov)localObject2).parseFrom((byte[])localObject1);
            }
            localcjm.aasc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258474);
          return 0;
        case 6: 
          localcjm.aasd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258474);
          return 0;
        }
        localcjm.aase = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258474);
        return 0;
      }
      AppMethodBeat.o(258474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjm
 * JD-Core Version:    0.7.0.1
 */