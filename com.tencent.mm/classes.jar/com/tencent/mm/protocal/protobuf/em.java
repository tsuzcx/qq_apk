package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class em
  extends buy
{
  public String fBA;
  public int knS;
  public int scene;
  public String session_id;
  public String url;
  public String wqH;
  public int wqa;
  public int wqb;
  public int wqc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14698);
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
      if (this.fBA != null) {
        paramVarArgs.e(3, this.fBA);
      }
      if (this.wqH != null) {
        paramVarArgs.e(4, this.wqH);
      }
      paramVarArgs.aO(5, this.scene);
      paramVarArgs.aO(6, this.wqc);
      paramVarArgs.aO(7, this.wqb);
      paramVarArgs.aO(8, this.knS);
      paramVarArgs.aO(10, this.wqa);
      if (this.session_id != null) {
        paramVarArgs.e(11, this.session_id);
      }
      AppMethodBeat.o(14698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.fBA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.fBA);
      }
      paramInt = i;
      if (this.wqH != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wqH);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.scene) + e.a.a.b.b.a.bl(6, this.wqc) + e.a.a.b.b.a.bl(7, this.wqb) + e.a.a.b.b.a.bl(8, this.knS) + e.a.a.b.b.a.bl(10, this.wqa);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.session_id);
      }
      AppMethodBeat.o(14698);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        em localem = (em)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(14698);
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
            localem.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14698);
          return 0;
        case 2: 
          localem.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14698);
          return 0;
        case 3: 
          localem.fBA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14698);
          return 0;
        case 4: 
          localem.wqH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14698);
          return 0;
        case 5: 
          localem.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14698);
          return 0;
        case 6: 
          localem.wqc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14698);
          return 0;
        case 7: 
          localem.wqb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14698);
          return 0;
        case 8: 
          localem.knS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14698);
          return 0;
        case 10: 
          localem.wqa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14698);
          return 0;
        }
        localem.session_id = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(14698);
        return 0;
      }
      AppMethodBeat.o(14698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.em
 * JD-Core Version:    0.7.0.1
 */