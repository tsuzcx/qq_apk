package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dql
  extends cvw
{
  public String HWV;
  public String HWW;
  public String HWX;
  public String HWZ;
  public String HXj;
  public int HXo;
  public String HXp;
  public String desc;
  public int vxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72607);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HWV != null) {
        paramVarArgs.d(2, this.HWV);
      }
      if (this.HWW != null) {
        paramVarArgs.d(3, this.HWW);
      }
      if (this.HWX != null) {
        paramVarArgs.d(4, this.HWX);
      }
      paramVarArgs.aS(5, this.vxx);
      if (this.desc != null) {
        paramVarArgs.d(6, this.desc);
      }
      paramVarArgs.aS(7, this.HXo);
      if (this.HWZ != null) {
        paramVarArgs.d(8, this.HWZ);
      }
      if (this.HXj != null) {
        paramVarArgs.d(9, this.HXj);
      }
      if (this.HXp != null) {
        paramVarArgs.d(10, this.HXp);
      }
      AppMethodBeat.o(72607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HWV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HWV);
      }
      i = paramInt;
      if (this.HWW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HWW);
      }
      paramInt = i;
      if (this.HWX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HWX);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.vxx);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.desc);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.HXo);
      paramInt = i;
      if (this.HWZ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HWZ);
      }
      i = paramInt;
      if (this.HXj != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HXj);
      }
      paramInt = i;
      if (this.HXp != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HXp);
      }
      AppMethodBeat.o(72607);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dql localdql = (dql)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72607);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdql.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72607);
          return 0;
        case 2: 
          localdql.HWV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 3: 
          localdql.HWW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 4: 
          localdql.HWX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 5: 
          localdql.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72607);
          return 0;
        case 6: 
          localdql.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 7: 
          localdql.HXo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72607);
          return 0;
        case 8: 
          localdql.HWZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 9: 
          localdql.HXj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72607);
          return 0;
        }
        localdql.HXp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72607);
        return 0;
      }
      AppMethodBeat.o(72607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dql
 * JD-Core Version:    0.7.0.1
 */