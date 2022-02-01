package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class byz
  extends com.tencent.mm.bw.a
{
  public long Hkz;
  public LinkedList<b> HlR;
  public bqe HlS;
  public long HlT;
  public long dmg;
  public long id;
  
  public byz()
  {
    AppMethodBeat.i(110903);
    this.HlR = new LinkedList();
    AppMethodBeat.o(110903);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.id);
      paramVarArgs.e(2, 6, this.HlR);
      if (this.HlS != null)
      {
        paramVarArgs.lJ(3, this.HlS.computeSize());
        this.HlS.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(4, this.dmg);
      paramVarArgs.aZ(5, this.Hkz);
      paramVarArgs.aZ(6, this.HlT);
      AppMethodBeat.o(110904);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.id) + 0 + f.a.a.a.c(2, 6, this.HlR);
      paramInt = i;
      if (this.HlS != null) {
        paramInt = i + f.a.a.a.lI(3, this.HlS.computeSize());
      }
      i = f.a.a.b.b.a.p(4, this.dmg);
      int j = f.a.a.b.b.a.p(5, this.Hkz);
      int k = f.a.a.b.b.a.p(6, this.HlT);
      AppMethodBeat.o(110904);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HlR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(110904);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byz localbyz = (byz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110904);
        return -1;
      case 1: 
        localbyz.id = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110904);
        return 0;
      case 2: 
        localbyz.HlR.add(((f.a.a.a.a)localObject1).OmT.gCk());
        AppMethodBeat.o(110904);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bqe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyz.HlS = ((bqe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110904);
        return 0;
      case 4: 
        localbyz.dmg = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110904);
        return 0;
      case 5: 
        localbyz.Hkz = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110904);
        return 0;
      }
      localbyz.HlT = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(110904);
      return 0;
    }
    AppMethodBeat.o(110904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byz
 * JD-Core Version:    0.7.0.1
 */