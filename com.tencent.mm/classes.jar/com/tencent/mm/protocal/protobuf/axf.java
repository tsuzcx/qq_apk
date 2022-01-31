package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axf
  extends buy
{
  public String cwc;
  public int kNx;
  public String packageName;
  public int scene;
  public String url;
  public int xmA;
  public int xmB;
  public String xmC;
  public String xmy;
  public String xmz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96250);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      if (this.xmy != null) {
        paramVarArgs.e(3, this.xmy);
      }
      paramVarArgs.aO(4, this.scene);
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      if (this.xmz != null) {
        paramVarArgs.e(6, this.xmz);
      }
      paramVarArgs.aO(7, this.kNx);
      paramVarArgs.aO(8, this.xmA);
      paramVarArgs.aO(9, this.xmB);
      if (this.xmC != null) {
        paramVarArgs.e(10, this.xmC);
      }
      if (this.packageName != null) {
        paramVarArgs.e(11, this.packageName);
      }
      AppMethodBeat.o(96250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cwc);
      }
      i = paramInt;
      if (this.xmy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xmy);
      }
      i += e.a.a.b.b.a.bl(4, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.url);
      }
      i = paramInt;
      if (this.xmz != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xmz);
      }
      i = i + e.a.a.b.b.a.bl(7, this.kNx) + e.a.a.b.b.a.bl(8, this.xmA) + e.a.a.b.b.a.bl(9, this.xmB);
      paramInt = i;
      if (this.xmC != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xmC);
      }
      i = paramInt;
      if (this.packageName != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.packageName);
      }
      AppMethodBeat.o(96250);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96250);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axf localaxf = (axf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96250);
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
            localaxf.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96250);
          return 0;
        case 2: 
          localaxf.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96250);
          return 0;
        case 3: 
          localaxf.xmy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96250);
          return 0;
        case 4: 
          localaxf.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96250);
          return 0;
        case 5: 
          localaxf.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96250);
          return 0;
        case 6: 
          localaxf.xmz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96250);
          return 0;
        case 7: 
          localaxf.kNx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96250);
          return 0;
        case 8: 
          localaxf.xmA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96250);
          return 0;
        case 9: 
          localaxf.xmB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96250);
          return 0;
        case 10: 
          localaxf.xmC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96250);
          return 0;
        }
        localaxf.packageName = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96250);
        return 0;
      }
      AppMethodBeat.o(96250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axf
 * JD-Core Version:    0.7.0.1
 */