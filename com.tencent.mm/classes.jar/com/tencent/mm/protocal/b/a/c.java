package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agi;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String Csg;
  public agi Csh;
  public String desc;
  public LinkedList<afy> gKs;
  public long oJi;
  public String title;
  
  public c()
  {
    AppMethodBeat.i(94808);
    this.gKs = new LinkedList();
    AppMethodBeat.o(94808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.gKs);
      if (this.Csg != null) {
        paramVarArgs.d(4, this.Csg);
      }
      if (this.Csh != null)
      {
        paramVarArgs.kX(5, this.Csh.computeSize());
        this.Csh.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.oJi);
      AppMethodBeat.o(94809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.desc);
      }
      i += f.a.a.a.c(3, 8, this.gKs);
      paramInt = i;
      if (this.Csg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Csg);
      }
      i = paramInt;
      if (this.Csh != null) {
        i = paramInt + f.a.a.a.kW(5, this.Csh.computeSize());
      }
      paramInt = f.a.a.b.b.a.q(6, this.oJi);
      AppMethodBeat.o(94809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.gKs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(94809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94809);
          return -1;
        case 1: 
          localc.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 2: 
          localc.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.gKs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        case 4: 
          localc.Csg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.Csh = ((agi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        }
        localc.oJi = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(94809);
        return 0;
      }
      AppMethodBeat.o(94809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.c
 * JD-Core Version:    0.7.0.1
 */