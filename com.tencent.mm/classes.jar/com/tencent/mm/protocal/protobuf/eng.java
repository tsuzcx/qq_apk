package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eng
  extends dop
{
  public String Lsm;
  public String Lsn;
  public String Lso;
  public String MD5;
  public boolean Nld;
  public LinkedList<String> Nle;
  public String Nlf;
  public boolean Nli;
  public int Scene;
  
  public eng()
  {
    AppMethodBeat.i(104842);
    this.Nle = new LinkedList();
    AppMethodBeat.o(104842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104843);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MD5 != null) {
        paramVarArgs.e(2, this.MD5);
      }
      paramVarArgs.cc(3, this.Nli);
      paramVarArgs.cc(4, this.Nld);
      paramVarArgs.e(5, 1, this.Nle);
      if (this.Lsm != null) {
        paramVarArgs.e(6, this.Lsm);
      }
      if (this.Nlf != null) {
        paramVarArgs.e(7, this.Nlf);
      }
      if (this.Lso != null) {
        paramVarArgs.e(8, this.Lso);
      }
      if (this.Lsn != null) {
        paramVarArgs.e(9, this.Lsn);
      }
      paramVarArgs.aM(10, this.Scene);
      AppMethodBeat.o(104843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MD5);
      }
      i = i + (g.a.a.b.b.a.fS(3) + 1) + (g.a.a.b.b.a.fS(4) + 1) + g.a.a.a.c(5, 1, this.Nle);
      paramInt = i;
      if (this.Lsm != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lsm);
      }
      i = paramInt;
      if (this.Nlf != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Nlf);
      }
      paramInt = i;
      if (this.Lso != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Lso);
      }
      i = paramInt;
      if (this.Lsn != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Lsn);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.Scene);
      AppMethodBeat.o(104843);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nle.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eng localeng = (eng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104843);
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
            localeng.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104843);
          return 0;
        case 2: 
          localeng.MD5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 3: 
          localeng.Nli = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(104843);
          return 0;
        case 4: 
          localeng.Nld = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(104843);
          return 0;
        case 5: 
          localeng.Nle.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(104843);
          return 0;
        case 6: 
          localeng.Lsm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 7: 
          localeng.Nlf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 8: 
          localeng.Lso = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 9: 
          localeng.Lsn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104843);
          return 0;
        }
        localeng.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104843);
        return 0;
      }
      AppMethodBeat.o(104843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eng
 * JD-Core Version:    0.7.0.1
 */