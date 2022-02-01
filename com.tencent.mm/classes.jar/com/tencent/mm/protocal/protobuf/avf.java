package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avf
  extends dyy
{
  public int SHA;
  public int SHB;
  public int SHC;
  public int SHD;
  public int SHE;
  public LinkedList<bcz> SHy;
  public bah SHz;
  public String title;
  
  public avf()
  {
    AppMethodBeat.i(230993);
    this.SHy = new LinkedList();
    AppMethodBeat.o(230993);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230996);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SHy);
      if (this.SHz != null)
      {
        paramVarArgs.oE(3, this.SHz.computeSize());
        this.SHz.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.SHA);
      paramVarArgs.aY(5, this.SHB);
      paramVarArgs.aY(6, this.SHC);
      paramVarArgs.aY(7, this.SHD);
      if (this.title != null) {
        paramVarArgs.f(8, this.title);
      }
      paramVarArgs.aY(9, this.SHE);
      AppMethodBeat.o(230996);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label820;
      }
    }
    label820:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SHy);
      paramInt = i;
      if (this.SHz != null) {
        paramInt = i + g.a.a.a.oD(3, this.SHz.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.SHA) + g.a.a.b.b.a.bM(5, this.SHB) + g.a.a.b.b.a.bM(6, this.SHC) + g.a.a.b.b.a.bM(7, this.SHD);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.title);
      }
      i = g.a.a.b.b.a.bM(9, this.SHE);
      AppMethodBeat.o(230996);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SHy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230996);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avf localavf = (avf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230996);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localavf.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230996);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcz)localObject2).parseFrom((byte[])localObject1);
            }
            localavf.SHy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230996);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bah();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bah)localObject2).parseFrom((byte[])localObject1);
            }
            localavf.SHz = ((bah)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230996);
          return 0;
        case 4: 
          localavf.SHA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230996);
          return 0;
        case 5: 
          localavf.SHB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230996);
          return 0;
        case 6: 
          localavf.SHC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230996);
          return 0;
        case 7: 
          localavf.SHD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230996);
          return 0;
        case 8: 
          localavf.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230996);
          return 0;
        }
        localavf.SHE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(230996);
        return 0;
      }
      AppMethodBeat.o(230996);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avf
 * JD-Core Version:    0.7.0.1
 */