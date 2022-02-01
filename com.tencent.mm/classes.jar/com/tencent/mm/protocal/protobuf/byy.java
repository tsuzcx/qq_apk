package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byy
  extends dop
{
  public acc KOF;
  public int KXD;
  public String MbW;
  public int MbZ;
  public String Mef;
  public int Meg;
  public boolean Meh;
  public cyd Mei;
  public String Mej;
  public LinkedList<crc> Mek;
  public int Mel;
  public boolean Mem;
  public boolean Men;
  public String dNI;
  public String path;
  public int scene;
  public int type;
  public String username;
  
  public byy()
  {
    AppMethodBeat.i(123586);
    this.Meh = false;
    this.Mek = new LinkedList();
    AppMethodBeat.o(123586);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123587);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.type);
      if (this.dNI != null) {
        paramVarArgs.e(3, this.dNI);
      }
      paramVarArgs.aM(4, this.KXD);
      if (this.Mef != null) {
        paramVarArgs.e(5, this.Mef);
      }
      paramVarArgs.aM(6, this.MbZ);
      paramVarArgs.aM(7, this.Meg);
      if (this.MbW != null) {
        paramVarArgs.e(8, this.MbW);
      }
      paramVarArgs.cc(9, this.Meh);
      if (this.Mei != null)
      {
        paramVarArgs.ni(10, this.Mei.computeSize());
        this.Mei.writeFields(paramVarArgs);
      }
      if (this.Mej != null) {
        paramVarArgs.e(11, this.Mej);
      }
      paramVarArgs.e(12, 8, this.Mek);
      paramVarArgs.aM(13, this.Mel);
      if (this.username != null) {
        paramVarArgs.e(14, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(15, this.path);
      }
      paramVarArgs.cc(16, this.Mem);
      paramVarArgs.cc(17, this.Men);
      paramVarArgs.aM(18, this.scene);
      if (this.KOF != null)
      {
        paramVarArgs.ni(19, this.KOF.computeSize());
        this.KOF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1530;
      }
    }
    label1530:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dNI);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.KXD);
      paramInt = i;
      if (this.Mef != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mef);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.MbZ) + g.a.a.b.b.a.bu(7, this.Meg);
      paramInt = i;
      if (this.MbW != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MbW);
      }
      i = paramInt + (g.a.a.b.b.a.fS(9) + 1);
      paramInt = i;
      if (this.Mei != null) {
        paramInt = i + g.a.a.a.nh(10, this.Mei.computeSize());
      }
      i = paramInt;
      if (this.Mej != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.Mej);
      }
      i = i + g.a.a.a.c(12, 8, this.Mek) + g.a.a.b.b.a.bu(13, this.Mel);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.path);
      }
      i = i + (g.a.a.b.b.a.fS(16) + 1) + (g.a.a.b.b.a.fS(17) + 1) + g.a.a.b.b.a.bu(18, this.scene);
      paramInt = i;
      if (this.KOF != null) {
        paramInt = i + g.a.a.a.nh(19, this.KOF.computeSize());
      }
      AppMethodBeat.o(123587);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mek.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byy localbyy = (byy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123587);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbyy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 2: 
          localbyy.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123587);
          return 0;
        case 3: 
          localbyy.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 4: 
          localbyy.KXD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123587);
          return 0;
        case 5: 
          localbyy.Mef = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 6: 
          localbyy.MbZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123587);
          return 0;
        case 7: 
          localbyy.Meg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123587);
          return 0;
        case 8: 
          localbyy.MbW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 9: 
          localbyy.Meh = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(123587);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbyy.Mei = ((cyd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 11: 
          localbyy.Mej = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbyy.Mek.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 13: 
          localbyy.Mel = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123587);
          return 0;
        case 14: 
          localbyy.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 15: 
          localbyy.path = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 16: 
          localbyy.Mem = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(123587);
          return 0;
        case 17: 
          localbyy.Men = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(123587);
          return 0;
        case 18: 
          localbyy.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123587);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbyy.KOF = ((acc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      AppMethodBeat.o(123587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byy
 * JD-Core Version:    0.7.0.1
 */