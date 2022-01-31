package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eo
  extends buy
{
  public String content;
  public int knS;
  public int scene;
  public String session_id;
  public String title;
  public String url;
  public long wqJ;
  public int wqK;
  public int wqa;
  public int wqb;
  public int wqc;
  public long wqd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14700);
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
      if (this.content != null) {
        paramVarArgs.e(4, this.content);
      }
      paramVarArgs.am(5, this.wqJ);
      paramVarArgs.aO(6, this.knS);
      paramVarArgs.aO(7, this.wqK);
      if (this.title != null) {
        paramVarArgs.e(8, this.title);
      }
      paramVarArgs.aO(9, this.scene);
      paramVarArgs.aO(10, this.wqc);
      paramVarArgs.aO(11, this.wqb);
      paramVarArgs.aO(12, this.wqa);
      if (this.session_id != null) {
        paramVarArgs.e(13, this.session_id);
      }
      paramVarArgs.am(14, this.wqd);
      AppMethodBeat.o(14700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label933;
      }
    }
    label933:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.content);
      }
      i = i + e.a.a.b.b.a.p(5, this.wqJ) + e.a.a.b.b.a.bl(6, this.knS) + e.a.a.b.b.a.bl(7, this.wqK);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.title);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.scene) + e.a.a.b.b.a.bl(10, this.wqc) + e.a.a.b.b.a.bl(11, this.wqb) + e.a.a.b.b.a.bl(12, this.wqa);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.session_id);
      }
      i = e.a.a.b.b.a.p(14, this.wqd);
      AppMethodBeat.o(14700);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14700);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        eo localeo = (eo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(14700);
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
            localeo.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14700);
          return 0;
        case 2: 
          localeo.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14700);
          return 0;
        case 4: 
          localeo.content = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14700);
          return 0;
        case 5: 
          localeo.wqJ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(14700);
          return 0;
        case 6: 
          localeo.knS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14700);
          return 0;
        case 7: 
          localeo.wqK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14700);
          return 0;
        case 8: 
          localeo.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14700);
          return 0;
        case 9: 
          localeo.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14700);
          return 0;
        case 10: 
          localeo.wqc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14700);
          return 0;
        case 11: 
          localeo.wqb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14700);
          return 0;
        case 12: 
          localeo.wqa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14700);
          return 0;
        case 13: 
          localeo.session_id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14700);
          return 0;
        }
        localeo.wqd = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(14700);
        return 0;
      }
      AppMethodBeat.o(14700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eo
 * JD-Core Version:    0.7.0.1
 */