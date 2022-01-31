package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ek
  extends buy
{
  public String fgl;
  public int nettype;
  public int scene;
  public String session_id;
  public String url;
  public int wqb;
  public int wqc;
  public int wqs;
  public int wqt;
  public long wqu;
  public long wqv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14693);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.fgl != null) {
        paramVarArgs.e(3, this.fgl);
      }
      paramVarArgs.aO(4, this.scene);
      paramVarArgs.aO(5, this.wqc);
      paramVarArgs.aO(6, this.nettype);
      if (this.session_id != null) {
        paramVarArgs.e(7, this.session_id);
      }
      paramVarArgs.aO(8, this.wqb);
      paramVarArgs.aO(9, this.wqs);
      paramVarArgs.aO(10, this.wqt);
      paramVarArgs.am(11, this.wqu);
      paramVarArgs.am(12, this.wqv);
      AppMethodBeat.o(14693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label880;
      }
    }
    label880:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.fgl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.fgl);
      }
      i = i + e.a.a.b.b.a.bl(4, this.scene) + e.a.a.b.b.a.bl(5, this.wqc) + e.a.a.b.b.a.bl(6, this.nettype);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.session_id);
      }
      i = e.a.a.b.b.a.bl(8, this.wqb);
      int j = e.a.a.b.b.a.bl(9, this.wqs);
      int k = e.a.a.b.b.a.bl(10, this.wqt);
      int m = e.a.a.b.b.a.p(11, this.wqu);
      int n = e.a.a.b.b.a.p(12, this.wqv);
      AppMethodBeat.o(14693);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ek localek = (ek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(14693);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localek.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14693);
          return 0;
        case 2: 
          localek.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14693);
          return 0;
        case 3: 
          localek.fgl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14693);
          return 0;
        case 4: 
          localek.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14693);
          return 0;
        case 5: 
          localek.wqc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14693);
          return 0;
        case 6: 
          localek.nettype = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14693);
          return 0;
        case 7: 
          localek.session_id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14693);
          return 0;
        case 8: 
          localek.wqb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14693);
          return 0;
        case 9: 
          localek.wqs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14693);
          return 0;
        case 10: 
          localek.wqt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14693);
          return 0;
        case 11: 
          localek.wqu = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(14693);
          return 0;
        }
        localek.wqv = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(14693);
        return 0;
      }
      AppMethodBeat.o(14693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ek
 * JD-Core Version:    0.7.0.1
 */