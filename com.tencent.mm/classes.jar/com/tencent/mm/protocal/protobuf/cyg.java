package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyg
  extends erp
{
  public String YAb;
  public gol aaDf;
  public String aaDg;
  public dev aaDh;
  public int aaDi;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259259);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaDh != null)
      {
        paramVarArgs.qD(2, this.aaDh.computeSize());
        this.aaDh.writeFields(paramVarArgs);
      }
      if (this.aaDg != null) {
        paramVarArgs.g(3, this.aaDg);
      }
      if (this.aaDf != null)
      {
        paramVarArgs.qD(4, this.aaDf.computeSize());
        this.aaDf.writeFields(paramVarArgs);
      }
      if (this.YAb != null) {
        paramVarArgs.g(5, this.YAb);
      }
      paramVarArgs.bS(6, this.aaDi);
      if (this.scope != null) {
        paramVarArgs.g(7, this.scope);
      }
      AppMethodBeat.o(259259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label776;
      }
    }
    label776:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaDh != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaDh.computeSize());
      }
      i = paramInt;
      if (this.aaDg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaDg);
      }
      paramInt = i;
      if (this.aaDf != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaDf.computeSize());
      }
      i = paramInt;
      if (this.YAb != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YAb);
      }
      i += i.a.a.b.b.a.cJ(6, this.aaDi);
      paramInt = i;
      if (this.scope != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.scope);
      }
      AppMethodBeat.o(259259);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259259);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cyg localcyg = (cyg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259259);
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
            localcyg.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259259);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dev();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dev)localObject2).parseFrom((byte[])localObject1);
            }
            localcyg.aaDh = ((dev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259259);
          return 0;
        case 3: 
          localcyg.aaDg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259259);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localcyg.aaDf = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259259);
          return 0;
        case 5: 
          localcyg.YAb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259259);
          return 0;
        case 6: 
          localcyg.aaDi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259259);
          return 0;
        }
        localcyg.scope = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259259);
        return 0;
      }
      AppMethodBeat.o(259259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyg
 * JD-Core Version:    0.7.0.1
 */