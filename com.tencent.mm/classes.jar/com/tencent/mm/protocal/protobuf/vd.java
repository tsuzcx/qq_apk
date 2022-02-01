package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vd
  extends ckq
{
  public String CXd;
  public String CXe;
  public String CXf;
  public String CXg;
  public String CXh;
  public String CXi;
  public int Scene;
  public String Title;
  public String hnC;
  public String hnp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63271);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnp != null) {
        paramVarArgs.d(2, this.hnp);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.CXd != null) {
        paramVarArgs.d(4, this.CXd);
      }
      if (this.CXe != null) {
        paramVarArgs.d(5, this.CXe);
      }
      if (this.CXf != null) {
        paramVarArgs.d(6, this.CXf);
      }
      if (this.CXg != null) {
        paramVarArgs.d(7, this.CXg);
      }
      if (this.CXh != null) {
        paramVarArgs.d(8, this.CXh);
      }
      if (this.hnC != null) {
        paramVarArgs.d(9, this.hnC);
      }
      paramVarArgs.aR(10, this.Scene);
      if (this.CXi != null) {
        paramVarArgs.d(11, this.CXi);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnp);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.CXd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CXd);
      }
      i = paramInt;
      if (this.CXe != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CXe);
      }
      paramInt = i;
      if (this.CXf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CXf);
      }
      i = paramInt;
      if (this.CXg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CXg);
      }
      paramInt = i;
      if (this.CXh != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CXh);
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hnC);
      }
      i += f.a.a.b.b.a.bA(10, this.Scene);
      paramInt = i;
      if (this.CXi != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CXi);
      }
      AppMethodBeat.o(63271);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(63271);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vd localvd = (vd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63271);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvd.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63271);
          return 0;
        case 2: 
          localvd.hnp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 3: 
          localvd.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 4: 
          localvd.CXd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 5: 
          localvd.CXe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 6: 
          localvd.CXf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 7: 
          localvd.CXg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 8: 
          localvd.CXh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 9: 
          localvd.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 10: 
          localvd.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(63271);
          return 0;
        }
        localvd.CXi = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(63271);
        return 0;
      }
      AppMethodBeat.o(63271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vd
 * JD-Core Version:    0.7.0.1
 */