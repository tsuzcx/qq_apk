package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bti
  extends com.tencent.mm.bx.a
{
  public int aabm;
  public int aabn;
  public dou aabo;
  public LinkedList<ebh> aabp;
  public int end_time;
  public int msg_type;
  public int priority;
  public int start_time;
  
  public bti()
  {
    AppMethodBeat.i(259521);
    this.aabp = new LinkedList();
    AppMethodBeat.o(259521);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259528);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.priority);
      paramVarArgs.bS(2, this.aabm);
      paramVarArgs.bS(3, this.start_time);
      paramVarArgs.bS(4, this.end_time);
      paramVarArgs.bS(5, this.msg_type);
      paramVarArgs.bS(6, this.aabn);
      if (this.aabo != null)
      {
        paramVarArgs.qD(7, this.aabo.computeSize());
        this.aabo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.aabp);
      AppMethodBeat.o(259528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.priority) + 0 + i.a.a.b.b.a.cJ(2, this.aabm) + i.a.a.b.b.a.cJ(3, this.start_time) + i.a.a.b.b.a.cJ(4, this.end_time) + i.a.a.b.b.a.cJ(5, this.msg_type) + i.a.a.b.b.a.cJ(6, this.aabn);
      paramInt = i;
      if (this.aabo != null) {
        paramInt = i + i.a.a.a.qC(7, this.aabo.computeSize());
      }
      i = i.a.a.a.c(8, 8, this.aabp);
      AppMethodBeat.o(259528);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aabp.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bti localbti = (bti)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259528);
        return -1;
      case 1: 
        localbti.priority = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259528);
        return 0;
      case 2: 
        localbti.aabm = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259528);
        return 0;
      case 3: 
        localbti.start_time = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259528);
        return 0;
      case 4: 
        localbti.end_time = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259528);
        return 0;
      case 5: 
        localbti.msg_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259528);
        return 0;
      case 6: 
        localbti.aabn = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259528);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dou();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dou)localObject2).parseFrom((byte[])localObject1);
          }
          localbti.aabo = ((dou)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259528);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ebh();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ebh)localObject2).parseFrom((byte[])localObject1);
        }
        localbti.aabp.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259528);
      return 0;
    }
    AppMethodBeat.o(259528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bti
 * JD-Core Version:    0.7.0.1
 */