package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bar
  extends com.tencent.mm.cd.a
{
  public cry SMA;
  public int SMB;
  public String SMC;
  public LinkedList<ays> SMz;
  
  public bar()
  {
    AppMethodBeat.i(206823);
    this.SMz = new LinkedList();
    AppMethodBeat.o(206823);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206825);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SMz);
      if (this.SMA != null)
      {
        paramVarArgs.oE(2, this.SMA.computeSize());
        this.SMA.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.SMB);
      if (this.SMC != null) {
        paramVarArgs.f(4, this.SMC);
      }
      AppMethodBeat.o(206825);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.SMz) + 0;
      paramInt = i;
      if (this.SMA != null) {
        paramInt = i + g.a.a.a.oD(2, this.SMA.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.SMB);
      paramInt = i;
      if (this.SMC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SMC);
      }
      AppMethodBeat.o(206825);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SMz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(206825);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bar localbar = (bar)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(206825);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ays();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ays)localObject2).parseFrom((byte[])localObject1);
          }
          localbar.SMz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(206825);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cry();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cry)localObject2).parseFrom((byte[])localObject1);
          }
          localbar.SMA = ((cry)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(206825);
        return 0;
      case 3: 
        localbar.SMB = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(206825);
        return 0;
      }
      localbar.SMC = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(206825);
      return 0;
    }
    AppMethodBeat.o(206825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bar
 * JD-Core Version:    0.7.0.1
 */