package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fna
  extends dyl
{
  public int ULA;
  public String ULB;
  public String ULC;
  public String ULD;
  public LinkedList<fmz> ULx;
  public String ULy;
  public String ULz;
  public String jUb;
  public String jUc;
  public String jUe;
  
  public fna()
  {
    AppMethodBeat.i(186557);
    this.ULx = new LinkedList();
    AppMethodBeat.o(186557);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186561);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ULx);
      if (this.jUb != null) {
        paramVarArgs.f(3, this.jUb);
      }
      if (this.jUc != null) {
        paramVarArgs.f(4, this.jUc);
      }
      if (this.ULy != null) {
        paramVarArgs.f(5, this.ULy);
      }
      if (this.jUe != null) {
        paramVarArgs.f(6, this.jUe);
      }
      if (this.ULz != null) {
        paramVarArgs.f(7, this.ULz);
      }
      paramVarArgs.aY(8, this.ULA);
      if (this.ULB != null) {
        paramVarArgs.f(9, this.ULB);
      }
      if (this.ULC != null) {
        paramVarArgs.f(10, this.ULC);
      }
      if (this.ULD != null) {
        paramVarArgs.f(11, this.ULD);
      }
      AppMethodBeat.o(186561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label942;
      }
    }
    label942:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.ULx);
      paramInt = i;
      if (this.jUb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.jUb);
      }
      i = paramInt;
      if (this.jUc != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.jUc);
      }
      paramInt = i;
      if (this.ULy != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ULy);
      }
      i = paramInt;
      if (this.jUe != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.jUe);
      }
      paramInt = i;
      if (this.ULz != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ULz);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.ULA);
      paramInt = i;
      if (this.ULB != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.ULB);
      }
      i = paramInt;
      if (this.ULC != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.ULC);
      }
      paramInt = i;
      if (this.ULD != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.ULD);
      }
      AppMethodBeat.o(186561);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ULx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(186561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fna localfna = (fna)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(186561);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localfna.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(186561);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmz)localObject2).parseFrom((byte[])localObject1);
            }
            localfna.ULx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(186561);
          return 0;
        case 3: 
          localfna.jUb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(186561);
          return 0;
        case 4: 
          localfna.jUc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(186561);
          return 0;
        case 5: 
          localfna.ULy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(186561);
          return 0;
        case 6: 
          localfna.jUe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(186561);
          return 0;
        case 7: 
          localfna.ULz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(186561);
          return 0;
        case 8: 
          localfna.ULA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(186561);
          return 0;
        case 9: 
          localfna.ULB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(186561);
          return 0;
        case 10: 
          localfna.ULC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(186561);
          return 0;
        }
        localfna.ULD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(186561);
        return 0;
      }
      AppMethodBeat.o(186561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fna
 * JD-Core Version:    0.7.0.1
 */