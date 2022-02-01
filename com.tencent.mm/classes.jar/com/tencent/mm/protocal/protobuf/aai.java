package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aai
  extends com.tencent.mm.bw.a
{
  public String GjJ;
  public String GjK;
  public long GkZ;
  public String Gla;
  public String Glb;
  public bmz GrD;
  public String oEp;
  public String oEq;
  public String pqW;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.oEp != null) {
        paramVarArgs.d(2, this.oEp);
      }
      if (this.oEq != null) {
        paramVarArgs.d(3, this.oEq);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      paramVarArgs.aZ(5, this.GkZ);
      if (this.Gla != null) {
        paramVarArgs.d(6, this.Gla);
      }
      if (this.Glb != null) {
        paramVarArgs.d(7, this.Glb);
      }
      if (this.pqW != null) {
        paramVarArgs.d(8, this.pqW);
      }
      if (this.GrD != null)
      {
        paramVarArgs.lJ(9, this.GrD.computeSize());
        this.GrD.writeFields(paramVarArgs);
      }
      if (this.GjJ != null) {
        paramVarArgs.d(10, this.GjJ);
      }
      if (this.GjK != null) {
        paramVarArgs.d(11, this.GjK);
      }
      AppMethodBeat.o(113985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oEp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oEp);
      }
      i = paramInt;
      if (this.oEq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oEq);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.GkZ);
      paramInt = i;
      if (this.Gla != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gla);
      }
      i = paramInt;
      if (this.Glb != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Glb);
      }
      paramInt = i;
      if (this.pqW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pqW);
      }
      i = paramInt;
      if (this.GrD != null) {
        i = paramInt + f.a.a.a.lI(9, this.GrD.computeSize());
      }
      paramInt = i;
      if (this.GjJ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GjJ);
      }
      i = paramInt;
      if (this.GjK != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GjK);
      }
      AppMethodBeat.o(113985);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aai localaai = (aai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113985);
          return -1;
        case 1: 
          localaai.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 2: 
          localaai.oEp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 3: 
          localaai.oEq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 4: 
          localaai.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 5: 
          localaai.GkZ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(113985);
          return 0;
        case 6: 
          localaai.Gla = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 7: 
          localaai.Glb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 8: 
          localaai.pqW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bmz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaai.GrD = ((bmz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113985);
          return 0;
        case 10: 
          localaai.GjJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113985);
          return 0;
        }
        localaai.GjK = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113985);
        return 0;
      }
      AppMethodBeat.o(113985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aai
 * JD-Core Version:    0.7.0.1
 */