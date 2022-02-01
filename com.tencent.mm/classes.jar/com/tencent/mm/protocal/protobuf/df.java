package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class df
  extends com.tencent.mm.bw.a
{
  public long Brn;
  public int CreateTime;
  public int KHs;
  public dqi KHt;
  public int KHu;
  public dqi KHv;
  public int KHw;
  public int xKb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133144);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomId");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.KHv == null)
      {
        paramVarArgs = new b("Not all required fields were included: DigestContent");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.KHt != null)
      {
        paramVarArgs.ni(1, this.KHt.computeSize());
        this.KHt.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.Brn);
      paramVarArgs.aM(3, this.KHs);
      paramVarArgs.aM(4, this.CreateTime);
      paramVarArgs.aM(5, this.KHu);
      if (this.KHv != null)
      {
        paramVarArgs.ni(6, this.KHv.computeSize());
        this.KHv.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.KHw);
      paramVarArgs.aM(8, this.xKb);
      AppMethodBeat.o(133144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KHt == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = g.a.a.a.nh(1, this.KHt.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.Brn) + g.a.a.b.b.a.bu(3, this.KHs) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.KHu);
      paramInt = i;
      if (this.KHv != null) {
        paramInt = i + g.a.a.a.nh(6, this.KHv.computeSize());
      }
      i = g.a.a.b.b.a.bu(7, this.KHw);
      int j = g.a.a.b.b.a.bu(8, this.xKb);
      AppMethodBeat.o(133144);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KHt == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomId");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        if (this.KHv == null)
        {
          paramVarArgs = new b("Not all required fields were included: DigestContent");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        df localdf = (df)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133144);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdf.KHt = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 2: 
          localdf.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(133144);
          return 0;
        case 3: 
          localdf.KHs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133144);
          return 0;
        case 4: 
          localdf.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133144);
          return 0;
        case 5: 
          localdf.KHu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133144);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdf.KHv = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 7: 
          localdf.KHw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133144);
          return 0;
        }
        localdf.xKb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133144);
        return 0;
      }
      AppMethodBeat.o(133144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.df
 * JD-Core Version:    0.7.0.1
 */