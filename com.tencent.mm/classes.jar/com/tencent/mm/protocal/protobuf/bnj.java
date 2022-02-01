package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnj
  extends dyl
{
  public String CPt;
  public LinkedList<String> SYo;
  public LinkedList<String> SYu;
  public int SYv;
  public String mVH;
  
  public bnj()
  {
    AppMethodBeat.i(42638);
    this.SYu = new LinkedList();
    this.SYo = new LinkedList();
    AppMethodBeat.o(42638);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42639);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.SYu);
      paramVarArgs.e(3, 1, this.SYo);
      if (this.CPt != null) {
        paramVarArgs.f(4, this.CPt);
      }
      if (this.mVH != null) {
        paramVarArgs.f(5, this.mVH);
      }
      paramVarArgs.aY(6, this.SYv);
      AppMethodBeat.o(42639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label568;
      }
    }
    label568:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.SYu) + g.a.a.a.c(3, 1, this.SYo);
      paramInt = i;
      if (this.CPt != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CPt);
      }
      i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mVH);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.SYv);
      AppMethodBeat.o(42639);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SYu.clear();
        this.SYo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(42639);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bnj localbnj = (bnj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42639);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbnj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(42639);
          return 0;
        case 2: 
          localbnj.SYu.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 3: 
          localbnj.SYo.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 4: 
          localbnj.CPt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(42639);
          return 0;
        case 5: 
          localbnj.mVH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(42639);
          return 0;
        }
        localbnj.SYv = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(42639);
        return 0;
      }
      AppMethodBeat.o(42639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnj
 * JD-Core Version:    0.7.0.1
 */