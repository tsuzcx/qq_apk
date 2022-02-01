package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqk
  extends com.tencent.mm.cd.a
{
  public bd Sdp;
  public String Sjh;
  public LinkedList<String> TbA;
  
  public bqk()
  {
    AppMethodBeat.i(91482);
    this.TbA = new LinkedList();
    AppMethodBeat.o(91482);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91483);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.TbA);
      if (this.Sdp != null)
      {
        paramVarArgs.oE(2, this.Sdp.computeSize());
        this.Sdp.writeFields(paramVarArgs);
      }
      if (this.Sjh != null) {
        paramVarArgs.f(3, this.Sjh);
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 1, this.TbA) + 0;
      paramInt = i;
      if (this.Sdp != null) {
        paramInt = i + g.a.a.a.oD(2, this.Sdp.computeSize());
      }
      i = paramInt;
      if (this.Sjh != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sjh);
      }
      AppMethodBeat.o(91483);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TbA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bqk localbqk = (bqk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91483);
        return -1;
      case 1: 
        localbqk.TbA.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(91483);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bd localbd = new bd();
          if ((localObject != null) && (localObject.length > 0)) {
            localbd.parseFrom((byte[])localObject);
          }
          localbqk.Sdp = localbd;
          paramInt += 1;
        }
        AppMethodBeat.o(91483);
        return 0;
      }
      localbqk.Sjh = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(91483);
      return 0;
    }
    AppMethodBeat.o(91483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqk
 * JD-Core Version:    0.7.0.1
 */