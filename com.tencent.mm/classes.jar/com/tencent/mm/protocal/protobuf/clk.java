package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clk
  extends erp
{
  public LinkedList<ade> aatr;
  public enu aatx;
  public boolean aaty;
  public String aatz;
  public int type;
  
  public clk()
  {
    AppMethodBeat.i(257771);
    this.aatr = new LinkedList();
    AppMethodBeat.o(257771);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257772);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.type);
      if (this.aatx != null)
      {
        paramVarArgs.qD(3, this.aatx.computeSize());
        this.aatx.writeFields(paramVarArgs);
      }
      paramVarArgs.di(4, this.aaty);
      if (this.aatz != null) {
        paramVarArgs.g(5, this.aatz);
      }
      paramVarArgs.e(6, 8, this.aatr);
      AppMethodBeat.o(257772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label684;
      }
    }
    label684:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.aatx != null) {
        paramInt = i + i.a.a.a.qC(3, this.aatx.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.aatz != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aatz);
      }
      i = i.a.a.a.c(6, 8, this.aatr);
      AppMethodBeat.o(257772);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aatr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257772);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        clk localclk = (clk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257772);
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
            localclk.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257772);
          return 0;
        case 2: 
          localclk.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257772);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enu)localObject2).parseFrom((byte[])localObject1);
            }
            localclk.aatx = ((enu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257772);
          return 0;
        case 4: 
          localclk.aaty = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257772);
          return 0;
        case 5: 
          localclk.aatz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257772);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ade();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ade)localObject2).parseFrom((byte[])localObject1);
          }
          localclk.aatr.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257772);
        return 0;
      }
      AppMethodBeat.o(257772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clk
 * JD-Core Version:    0.7.0.1
 */