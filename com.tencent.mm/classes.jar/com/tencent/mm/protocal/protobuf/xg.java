package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xg
  extends cvw
{
  public String GoX;
  public String GoY;
  public String GoZ;
  public String Gpa;
  public String Gpb;
  public long Gpc;
  public String Gpd;
  public String Gpe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32161);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GoX != null) {
        paramVarArgs.d(2, this.GoX);
      }
      if (this.GoY != null) {
        paramVarArgs.d(3, this.GoY);
      }
      if (this.GoZ != null) {
        paramVarArgs.d(4, this.GoZ);
      }
      if (this.Gpa != null) {
        paramVarArgs.d(5, this.Gpa);
      }
      if (this.Gpb != null) {
        paramVarArgs.d(6, this.Gpb);
      }
      paramVarArgs.aZ(7, this.Gpc);
      if (this.Gpd != null) {
        paramVarArgs.d(8, this.Gpd);
      }
      if (this.Gpe != null) {
        paramVarArgs.d(9, this.Gpe);
      }
      AppMethodBeat.o(32161);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label797;
      }
    }
    label797:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GoX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GoX);
      }
      i = paramInt;
      if (this.GoY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GoY);
      }
      paramInt = i;
      if (this.GoZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GoZ);
      }
      i = paramInt;
      if (this.Gpa != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gpa);
      }
      paramInt = i;
      if (this.Gpb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gpb);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.Gpc);
      paramInt = i;
      if (this.Gpd != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gpd);
      }
      i = paramInt;
      if (this.Gpe != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gpe);
      }
      AppMethodBeat.o(32161);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32161);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xg localxg = (xg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32161);
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
            localxg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32161);
          return 0;
        case 2: 
          localxg.GoX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 3: 
          localxg.GoY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 4: 
          localxg.GoZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 5: 
          localxg.Gpa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 6: 
          localxg.Gpb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 7: 
          localxg.Gpc = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32161);
          return 0;
        case 8: 
          localxg.Gpd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32161);
          return 0;
        }
        localxg.Gpe = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32161);
        return 0;
      }
      AppMethodBeat.o(32161);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xg
 * JD-Core Version:    0.7.0.1
 */