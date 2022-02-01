package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ant
  extends cvw
{
  public alw GDR;
  public int GFA;
  public long GFx;
  public int GFy;
  public String GFz;
  public int direction;
  public b lastBuffer;
  public b likeBuffer;
  public String objectNonceId;
  public long rQN;
  public long rQR;
  public int rQU;
  public long rRn;
  public String sbR;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168973);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.rRn);
      paramVarArgs.aZ(3, this.GFx);
      paramVarArgs.aS(4, this.GFy);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.aZ(6, this.rQN);
      if (this.sbR != null) {
        paramVarArgs.d(7, this.sbR);
      }
      paramVarArgs.aZ(8, this.rQR);
      paramVarArgs.aS(9, this.scene);
      paramVarArgs.aS(10, this.direction);
      if (this.GFz != null) {
        paramVarArgs.d(11, this.GFz);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(12, this.objectNonceId);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(13, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.GFA);
      paramVarArgs.aS(15, this.rQU);
      if (this.likeBuffer != null) {
        paramVarArgs.c(16, this.likeBuffer);
      }
      AppMethodBeat.o(168973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1174;
      }
    }
    label1174:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.rRn) + f.a.a.b.b.a.p(3, this.GFx) + f.a.a.b.b.a.bz(4, this.GFy);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.rQN);
      paramInt = i;
      if (this.sbR != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sbR);
      }
      i = paramInt + f.a.a.b.b.a.p(8, this.rQR) + f.a.a.b.b.a.bz(9, this.scene) + f.a.a.b.b.a.bz(10, this.direction);
      paramInt = i;
      if (this.GFz != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GFz);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.objectNonceId);
      }
      paramInt = i;
      if (this.GDR != null) {
        paramInt = i + f.a.a.a.lI(13, this.GDR.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.GFA) + f.a.a.b.b.a.bz(15, this.rQU);
      paramInt = i;
      if (this.likeBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.likeBuffer);
      }
      AppMethodBeat.o(168973);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168973);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ant localant = (ant)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168973);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localant.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 2: 
          localant.rRn = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168973);
          return 0;
        case 3: 
          localant.GFx = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168973);
          return 0;
        case 4: 
          localant.GFy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168973);
          return 0;
        case 5: 
          localant.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168973);
          return 0;
        case 6: 
          localant.rQN = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168973);
          return 0;
        case 7: 
          localant.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 8: 
          localant.rQR = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168973);
          return 0;
        case 9: 
          localant.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168973);
          return 0;
        case 10: 
          localant.direction = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168973);
          return 0;
        case 11: 
          localant.GFz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 12: 
          localant.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localant.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 14: 
          localant.GFA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168973);
          return 0;
        case 15: 
          localant.rQU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168973);
          return 0;
        }
        localant.likeBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(168973);
        return 0;
      }
      AppMethodBeat.o(168973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ant
 * JD-Core Version:    0.7.0.1
 */