package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aip
  extends com.tencent.mm.bw.a
{
  public String EDo;
  public LinkedList<aiq> EDp;
  public String desc;
  public String title;
  
  public aip()
  {
    AppMethodBeat.i(91463);
    this.EDp = new LinkedList();
    AppMethodBeat.o(91463);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91464);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.EDo != null) {
        paramVarArgs.d(2, this.EDo);
      }
      paramVarArgs.e(3, 8, this.EDp);
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      AppMethodBeat.o(91464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EDo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EDo);
      }
      i += f.a.a.a.c(3, 8, this.EDp);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.desc);
      }
      AppMethodBeat.o(91464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EDp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aip localaip = (aip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91464);
          return -1;
        case 1: 
          localaip.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91464);
          return 0;
        case 2: 
          localaip.EDo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91464);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aiq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaip.EDp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91464);
          return 0;
        }
        localaip.desc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91464);
        return 0;
      }
      AppMethodBeat.o(91464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aip
 * JD-Core Version:    0.7.0.1
 */