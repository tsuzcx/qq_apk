package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clj
  extends dop
{
  public int Ler;
  public long MqG;
  public long MqH;
  public long MqI;
  public int offset;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169915);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.MqG);
      paramVarArgs.bb(3, this.MqH);
      if (this.query != null) {
        paramVarArgs.e(4, this.query);
      }
      paramVarArgs.aM(5, this.offset);
      paramVarArgs.aM(6, this.Ler);
      paramVarArgs.bb(7, this.MqI);
      AppMethodBeat.o(169915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.MqG) + g.a.a.b.b.a.r(3, this.MqH);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.query);
      }
      i = g.a.a.b.b.a.bu(5, this.offset);
      int j = g.a.a.b.b.a.bu(6, this.Ler);
      int k = g.a.a.b.b.a.r(7, this.MqI);
      AppMethodBeat.o(169915);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        clj localclj = (clj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169915);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localclj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169915);
          return 0;
        case 2: 
          localclj.MqG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169915);
          return 0;
        case 3: 
          localclj.MqH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169915);
          return 0;
        case 4: 
          localclj.query = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169915);
          return 0;
        case 5: 
          localclj.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169915);
          return 0;
        case 6: 
          localclj.Ler = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169915);
          return 0;
        }
        localclj.MqI = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169915);
        return 0;
      }
      AppMethodBeat.o(169915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clj
 * JD-Core Version:    0.7.0.1
 */