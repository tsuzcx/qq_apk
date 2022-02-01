package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dwb
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public LinkedList<aio> Gdq;
  public String Gdr;
  
  public dwb()
  {
    AppMethodBeat.i(110852);
    this.Gdq = new LinkedList();
    AppMethodBeat.o(110852);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110853);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110853);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.Gdq);
      if (this.Gdr != null) {
        paramVarArgs.d(2, this.Gdr);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      AppMethodBeat.o(110853);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Gdq) + 0;
      paramInt = i;
      if (this.Gdr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gdr);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      AppMethodBeat.o(110853);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gdq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Gdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110853);
        throw paramVarArgs;
      }
      AppMethodBeat.o(110853);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dwb localdwb = (dwb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110853);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aio();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwb.Gdq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110853);
        return 0;
      case 2: 
        localdwb.Gdr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(110853);
        return 0;
      }
      localdwb.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(110853);
      return 0;
    }
    AppMethodBeat.o(110853);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwb
 * JD-Core Version:    0.7.0.1
 */