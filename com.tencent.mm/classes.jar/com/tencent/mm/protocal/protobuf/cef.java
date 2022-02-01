package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cef
  extends dop
{
  public int HTO;
  public LinkedList<String> MjM;
  public String MjN;
  public LinkedList<String> MjO;
  public String Mju;
  public String Mjv;
  public String Mjy;
  public String dNI;
  public String dmc;
  public int scene;
  public String signature;
  public String url;
  
  public cef()
  {
    AppMethodBeat.i(82438);
    this.MjM = new LinkedList();
    this.MjO = new LinkedList();
    AppMethodBeat.o(82438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.dNI != null) {
        paramVarArgs.e(3, this.dNI);
      }
      paramVarArgs.e(4, 1, this.MjM);
      if (this.dmc != null) {
        paramVarArgs.e(5, this.dmc);
      }
      if (this.Mju != null) {
        paramVarArgs.e(6, this.Mju);
      }
      if (this.signature != null) {
        paramVarArgs.e(7, this.signature);
      }
      if (this.Mjv != null) {
        paramVarArgs.e(8, this.Mjv);
      }
      paramVarArgs.aM(9, this.scene);
      if (this.MjN != null) {
        paramVarArgs.e(10, this.MjN);
      }
      paramVarArgs.e(11, 1, this.MjO);
      if (this.Mjy != null) {
        paramVarArgs.e(12, this.Mjy);
      }
      paramVarArgs.aM(13, this.HTO);
      AppMethodBeat.o(82439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1010;
      }
    }
    label1010:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dNI);
      }
      i += g.a.a.a.c(4, 1, this.MjM);
      paramInt = i;
      if (this.dmc != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dmc);
      }
      i = paramInt;
      if (this.Mju != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Mju);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.signature);
      }
      i = paramInt;
      if (this.Mjv != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Mjv);
      }
      i += g.a.a.b.b.a.bu(9, this.scene);
      paramInt = i;
      if (this.MjN != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MjN);
      }
      i = paramInt + g.a.a.a.c(11, 1, this.MjO);
      paramInt = i;
      if (this.Mjy != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Mjy);
      }
      i = g.a.a.b.b.a.bu(13, this.HTO);
      AppMethodBeat.o(82439);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MjM.clear();
        this.MjO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cef localcef = (cef)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82439);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcef.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82439);
          return 0;
        case 2: 
          localcef.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 3: 
          localcef.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 4: 
          localcef.MjM.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 5: 
          localcef.dmc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 6: 
          localcef.Mju = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 7: 
          localcef.signature = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 8: 
          localcef.Mjv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 9: 
          localcef.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82439);
          return 0;
        case 10: 
          localcef.MjN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 11: 
          localcef.MjO.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 12: 
          localcef.Mjy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82439);
          return 0;
        }
        localcef.HTO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(82439);
        return 0;
      }
      AppMethodBeat.o(82439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cef
 * JD-Core Version:    0.7.0.1
 */