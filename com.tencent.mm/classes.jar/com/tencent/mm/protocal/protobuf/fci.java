package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fci
  extends dop
{
  public int LEg;
  public String Nhv;
  public LinkedList<String> Nyh;
  public boolean Nyi;
  public String Nyj;
  public boolean Nyk;
  public boolean Nyl;
  public String dNI;
  
  public fci()
  {
    AppMethodBeat.i(153313);
    this.Nyh = new LinkedList();
    AppMethodBeat.o(153313);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153314);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      paramVarArgs.e(3, 1, this.Nyh);
      paramVarArgs.cc(4, this.Nyi);
      if (this.Nyj != null) {
        paramVarArgs.e(5, this.Nyj);
      }
      paramVarArgs.cc(6, this.Nyk);
      if (this.Nhv != null) {
        paramVarArgs.e(7, this.Nhv);
      }
      paramVarArgs.cc(8, this.Nyl);
      paramVarArgs.aM(9, this.LEg);
      AppMethodBeat.o(153314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = i + g.a.a.a.c(3, 1, this.Nyh) + (g.a.a.b.b.a.fS(4) + 1);
      paramInt = i;
      if (this.Nyj != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Nyj);
      }
      i = paramInt + (g.a.a.b.b.a.fS(6) + 1);
      paramInt = i;
      if (this.Nhv != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Nhv);
      }
      i = g.a.a.b.b.a.fS(8);
      int j = g.a.a.b.b.a.bu(9, this.LEg);
      AppMethodBeat.o(153314);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nyh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fci localfci = (fci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153314);
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
            localfci.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153314);
          return 0;
        case 2: 
          localfci.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 3: 
          localfci.Nyh.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(153314);
          return 0;
        case 4: 
          localfci.Nyi = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153314);
          return 0;
        case 5: 
          localfci.Nyj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 6: 
          localfci.Nyk = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153314);
          return 0;
        case 7: 
          localfci.Nhv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 8: 
          localfci.Nyl = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153314);
          return 0;
        }
        localfci.LEg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153314);
        return 0;
      }
      AppMethodBeat.o(153314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fci
 * JD-Core Version:    0.7.0.1
 */