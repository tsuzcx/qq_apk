package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class tp
  extends com.tencent.mm.bx.a
{
  public String YZg;
  public String YZh;
  public String YZi;
  public LinkedList<to> nUC;
  public long object_id;
  
  public tp()
  {
    AppMethodBeat.i(259770);
    this.nUC = new LinkedList();
    AppMethodBeat.o(259770);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259774);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.object_id);
      if (this.YZg != null) {
        paramVarArgs.g(2, this.YZg);
      }
      paramVarArgs.e(3, 8, this.nUC);
      if (this.YZh != null) {
        paramVarArgs.g(4, this.YZh);
      }
      if (this.YZi != null) {
        paramVarArgs.g(5, this.YZi);
      }
      AppMethodBeat.o(259774);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.object_id) + 0;
      paramInt = i;
      if (this.YZg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YZg);
      }
      i = paramInt + i.a.a.a.c(3, 8, this.nUC);
      paramInt = i;
      if (this.YZh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YZh);
      }
      i = paramInt;
      if (this.YZi != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YZi);
      }
      AppMethodBeat.o(259774);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nUC.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259774);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      tp localtp = (tp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259774);
        return -1;
      case 1: 
        localtp.object_id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259774);
        return 0;
      case 2: 
        localtp.YZg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259774);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          to localto = new to();
          if ((localObject != null) && (localObject.length > 0)) {
            localto.parseFrom((byte[])localObject);
          }
          localtp.nUC.add(localto);
          paramInt += 1;
        }
        AppMethodBeat.o(259774);
        return 0;
      case 4: 
        localtp.YZh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259774);
        return 0;
      }
      localtp.YZi = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(259774);
      return 0;
    }
    AppMethodBeat.o(259774);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tp
 * JD-Core Version:    0.7.0.1
 */