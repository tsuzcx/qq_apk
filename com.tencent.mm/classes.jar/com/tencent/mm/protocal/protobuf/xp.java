package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xp
  extends cvw
{
  public String GpA;
  public String GpB;
  public String Gpw;
  public String Gpx;
  public String Gpy;
  public String Gpz;
  public int Scene;
  public String Title;
  public String ijZ;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63271);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ijZ != null) {
        paramVarArgs.d(2, this.ijZ);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Gpw != null) {
        paramVarArgs.d(4, this.Gpw);
      }
      if (this.Gpx != null) {
        paramVarArgs.d(5, this.Gpx);
      }
      if (this.Gpy != null) {
        paramVarArgs.d(6, this.Gpy);
      }
      if (this.Gpz != null) {
        paramVarArgs.d(7, this.Gpz);
      }
      if (this.GpA != null) {
        paramVarArgs.d(8, this.GpA);
      }
      if (this.ikm != null) {
        paramVarArgs.d(9, this.ikm);
      }
      paramVarArgs.aS(10, this.Scene);
      if (this.GpB != null) {
        paramVarArgs.d(11, this.GpB);
      }
      AppMethodBeat.o(63271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ijZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ijZ);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.Gpw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gpw);
      }
      i = paramInt;
      if (this.Gpx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gpx);
      }
      paramInt = i;
      if (this.Gpy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gpy);
      }
      i = paramInt;
      if (this.Gpz != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gpz);
      }
      paramInt = i;
      if (this.GpA != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GpA);
      }
      i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ikm);
      }
      i += f.a.a.b.b.a.bz(10, this.Scene);
      paramInt = i;
      if (this.GpB != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GpB);
      }
      AppMethodBeat.o(63271);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(63271);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xp localxp = (xp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63271);
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
            localxp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63271);
          return 0;
        case 2: 
          localxp.ijZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 3: 
          localxp.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 4: 
          localxp.Gpw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 5: 
          localxp.Gpx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 6: 
          localxp.Gpy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 7: 
          localxp.Gpz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 8: 
          localxp.GpA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 9: 
          localxp.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 10: 
          localxp.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(63271);
          return 0;
        }
        localxp.GpB = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(63271);
        return 0;
      }
      AppMethodBeat.o(63271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xp
 * JD-Core Version:    0.7.0.1
 */