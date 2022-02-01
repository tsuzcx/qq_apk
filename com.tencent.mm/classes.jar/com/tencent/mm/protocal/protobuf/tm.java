package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tm
  extends com.tencent.mm.bx.a
{
  public etg YCV;
  public String YMe;
  public dbk YZa;
  public adv YZb;
  public int mdS;
  public int state;
  public String text;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91384);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.state);
      if (this.YCV != null)
      {
        paramVarArgs.qD(2, this.YCV.computeSize());
        this.YCV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.mdS);
      if (this.YZa != null)
      {
        paramVarArgs.qD(4, this.YZa.computeSize());
        this.YZa.writeFields(paramVarArgs);
      }
      if (this.text != null) {
        paramVarArgs.g(5, this.text);
      }
      if (this.YMe != null) {
        paramVarArgs.g(6, this.YMe);
      }
      paramVarArgs.bS(7, this.wuj);
      if (this.YZb != null)
      {
        paramVarArgs.qD(8, this.YZb.computeSize());
        this.YZb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.state) + 0;
      paramInt = i;
      if (this.YCV != null) {
        paramInt = i + i.a.a.a.qC(2, this.YCV.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.mdS);
      paramInt = i;
      if (this.YZa != null) {
        paramInt = i + i.a.a.a.qC(4, this.YZa.computeSize());
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.text);
      }
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YMe);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.wuj);
      paramInt = i;
      if (this.YZb != null) {
        paramInt = i + i.a.a.a.qC(8, this.YZb.computeSize());
      }
      AppMethodBeat.o(91384);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      tm localtm = (tm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91384);
        return -1;
      case 1: 
        localtm.state = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91384);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etg)localObject2).parseFrom((byte[])localObject1);
          }
          localtm.YCV = ((etg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 3: 
        localtm.mdS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91384);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbk)localObject2).parseFrom((byte[])localObject1);
          }
          localtm.YZa = ((dbk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 5: 
        localtm.text = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 6: 
        localtm.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 7: 
        localtm.wuj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91384);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new adv();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((adv)localObject2).parseFrom((byte[])localObject1);
        }
        localtm.YZb = ((adv)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    AppMethodBeat.o(91384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tm
 * JD-Core Version:    0.7.0.1
 */