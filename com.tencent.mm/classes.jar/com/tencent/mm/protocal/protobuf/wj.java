package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wj
  extends dop
{
  public String KHN;
  public String LhB;
  public String Lhy;
  public String Lhz;
  public String dNQ;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72435);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNQ != null) {
        paramVarArgs.e(2, this.dNQ);
      }
      if (this.LhB != null) {
        paramVarArgs.e(3, this.LhB);
      }
      if (this.KHN != null) {
        paramVarArgs.e(4, this.KHN);
      }
      paramVarArgs.aM(5, this.yRL);
      if (this.Lhz != null) {
        paramVarArgs.e(6, this.Lhz);
      }
      if (this.Lhy != null) {
        paramVarArgs.e(7, this.Lhy);
      }
      AppMethodBeat.o(72435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dNQ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNQ);
      }
      i = paramInt;
      if (this.LhB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LhB);
      }
      paramInt = i;
      if (this.KHN != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KHN);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.yRL);
      paramInt = i;
      if (this.Lhz != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lhz);
      }
      i = paramInt;
      if (this.Lhy != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lhy);
      }
      AppMethodBeat.o(72435);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wj localwj = (wj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72435);
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
            localwj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72435);
          return 0;
        case 2: 
          localwj.dNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 3: 
          localwj.LhB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 4: 
          localwj.KHN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 5: 
          localwj.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72435);
          return 0;
        case 6: 
          localwj.Lhz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72435);
          return 0;
        }
        localwj.Lhy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72435);
        return 0;
      }
      AppMethodBeat.o(72435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wj
 * JD-Core Version:    0.7.0.1
 */