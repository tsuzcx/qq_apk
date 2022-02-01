package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhk
  extends com.tencent.mm.cd.a
{
  public int SRY;
  public int SRZ;
  public int SSa;
  public cxp SSb;
  public LinkedList<dix> SSc;
  public int end_time;
  public int msg_type;
  public int priority;
  
  public bhk()
  {
    AppMethodBeat.i(203355);
    this.SSc = new LinkedList();
    AppMethodBeat.o(203355);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203363);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.priority);
      paramVarArgs.aY(2, this.SRY);
      paramVarArgs.aY(3, this.SRZ);
      paramVarArgs.aY(4, this.end_time);
      paramVarArgs.aY(5, this.msg_type);
      paramVarArgs.aY(6, this.SSa);
      if (this.SSb != null)
      {
        paramVarArgs.oE(7, this.SSb.computeSize());
        this.SSb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.SSc);
      AppMethodBeat.o(203363);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.priority) + 0 + g.a.a.b.b.a.bM(2, this.SRY) + g.a.a.b.b.a.bM(3, this.SRZ) + g.a.a.b.b.a.bM(4, this.end_time) + g.a.a.b.b.a.bM(5, this.msg_type) + g.a.a.b.b.a.bM(6, this.SSa);
      paramInt = i;
      if (this.SSb != null) {
        paramInt = i + g.a.a.a.oD(7, this.SSb.computeSize());
      }
      i = g.a.a.a.c(8, 8, this.SSc);
      AppMethodBeat.o(203363);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SSc.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203363);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bhk localbhk = (bhk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203363);
        return -1;
      case 1: 
        localbhk.priority = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(203363);
        return 0;
      case 2: 
        localbhk.SRY = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(203363);
        return 0;
      case 3: 
        localbhk.SRZ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(203363);
        return 0;
      case 4: 
        localbhk.end_time = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(203363);
        return 0;
      case 5: 
        localbhk.msg_type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(203363);
        return 0;
      case 6: 
        localbhk.SSa = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(203363);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cxp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cxp)localObject2).parseFrom((byte[])localObject1);
          }
          localbhk.SSb = ((cxp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203363);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dix();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dix)localObject2).parseFrom((byte[])localObject1);
        }
        localbhk.SSc.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(203363);
      return 0;
    }
    AppMethodBeat.o(203363);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhk
 * JD-Core Version:    0.7.0.1
 */