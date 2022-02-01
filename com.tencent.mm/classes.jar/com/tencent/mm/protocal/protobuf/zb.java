package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zb
  extends dop
{
  public String Lki;
  public String Lkj;
  public String Lkk;
  public String Lkl;
  public String Lkm;
  public String Lkn;
  public int Scene;
  public String Title;
  public String jeV;
  public String jfi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63271);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jeV != null) {
        paramVarArgs.e(2, this.jeV);
      }
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.Lki != null) {
        paramVarArgs.e(4, this.Lki);
      }
      if (this.Lkj != null) {
        paramVarArgs.e(5, this.Lkj);
      }
      if (this.Lkk != null) {
        paramVarArgs.e(6, this.Lkk);
      }
      if (this.Lkl != null) {
        paramVarArgs.e(7, this.Lkl);
      }
      if (this.Lkm != null) {
        paramVarArgs.e(8, this.Lkm);
      }
      if (this.jfi != null) {
        paramVarArgs.e(9, this.jfi);
      }
      paramVarArgs.aM(10, this.Scene);
      if (this.Lkn != null) {
        paramVarArgs.e(11, this.Lkn);
      }
      AppMethodBeat.o(63271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jeV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jeV);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.Lki != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lki);
      }
      i = paramInt;
      if (this.Lkj != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lkj);
      }
      paramInt = i;
      if (this.Lkk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lkk);
      }
      i = paramInt;
      if (this.Lkl != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lkl);
      }
      paramInt = i;
      if (this.Lkm != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Lkm);
      }
      i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.jfi);
      }
      i += g.a.a.b.b.a.bu(10, this.Scene);
      paramInt = i;
      if (this.Lkn != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Lkn);
      }
      AppMethodBeat.o(63271);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(63271);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zb localzb = (zb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63271);
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
            localzb.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63271);
          return 0;
        case 2: 
          localzb.jeV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 3: 
          localzb.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 4: 
          localzb.Lki = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 5: 
          localzb.Lkj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 6: 
          localzb.Lkk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 7: 
          localzb.Lkl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 8: 
          localzb.Lkm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 9: 
          localzb.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 10: 
          localzb.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(63271);
          return 0;
        }
        localzb.Lkn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(63271);
        return 0;
      }
      AppMethodBeat.o(63271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zb
 * JD-Core Version:    0.7.0.1
 */